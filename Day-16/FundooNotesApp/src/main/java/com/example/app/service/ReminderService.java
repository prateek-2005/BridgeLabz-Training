package com.example.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.app.dto.ReminderRequest;
import com.example.app.dto.ReminderResponse;
import com.example.app.entity.Note;
import com.example.app.entity.Reminder;
import com.example.app.entity.User;
import com.example.app.messaging.ReminderMessage;
import com.example.app.messaging.ReminderProducer;
import com.example.app.repository.NoteRepository;
import com.example.app.repository.ReminderRepository;
import com.example.app.repository.UserRepository;

@Service
public class ReminderService {

	private final ReminderRepository reminderRepository;
	private final UserRepository userRepository;
	private final NoteRepository noteRepository;
	private final ReminderProducer reminderProducer;

	public ReminderService(ReminderRepository reminderRepository, UserRepository userRepository,
			NoteRepository noteRepository, ReminderProducer reminderProducer) {

		this.reminderRepository = reminderRepository;
		this.userRepository = userRepository;
		this.noteRepository = noteRepository;
		this.reminderProducer = reminderProducer;
	}

	public ReminderResponse createReminder(int userId, ReminderRequest request) {

		User owner = getUser(userId);

		Note note = null;

		if (request.getNoteId() != null) {

			note = noteRepository.findByNoteIdAndOwner(request.getNoteId(), owner)
					.orElseThrow(() -> new IllegalArgumentException("Note not found"));
		}

		Reminder reminder = Reminder.builder().message(request.getMessage()).reminderTime(request.getReminderTime())
				.owner(owner).note(note).completed(false).build();

		Reminder saved = reminderRepository.save(reminder);

		reminderProducer
				.sendReminder(new ReminderMessage(owner.getUserId(), saved.getMessage(), saved.getReminderTime()));

		return mapToResponse(saved);
	}

	public List<ReminderResponse> getMyReminders(int userId) {

		User owner = getUser(userId);

		return reminderRepository.findByOwner(owner).stream().map(this::mapToResponse).toList();
	}

	private User getUser(int userId) {

		return userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("User not found"));
	}

	private ReminderResponse mapToResponse(Reminder reminder) {

		return ReminderResponse.builder().reminderId(reminder.getReminderId()).message(reminder.getMessage())
				.reminderTime(reminder.getReminderTime()).completed(reminder.isCompleted())
				.noteId(reminder.getNote() != null ? reminder.getNote().getNoteId() : null).build();
	}
}
