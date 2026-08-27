package com.example.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.app.dto.ReminderRequest;
import com.example.app.dto.ReminderResponse;
import com.example.app.entity.Reminder;
import com.example.app.exception.ResourceNotFoundException;
import com.example.app.repository.ReminderRepository;

@Service
public class ReminderService {

    private final ReminderRepository reminderRepository;

    public ReminderService(ReminderRepository reminderRepository) {
        this.reminderRepository = reminderRepository;
    }

    public ReminderResponse createReminder(int userId, ReminderRequest request) {
        Reminder reminder = Reminder.builder()
                .ownerId(userId)
                .message(request.getMessage())
                .reminderTime(request.getReminderTime())
                .noteId(request.getNoteId())
                .completed(false)
                .processed(false)
                .build();

        return mapToResponse(reminderRepository.save(reminder));
    }

    public List<ReminderResponse> getMyReminders(int userId) {
        return reminderRepository.findByOwnerId(userId).stream()
                .map(this::mapToResponse)
                .toList();
    }

    public ReminderResponse markCompleted(int reminderId, int userId) {
        Reminder reminder = getOwnedReminder(reminderId, userId);
        reminder.setCompleted(true);
        return mapToResponse(reminderRepository.save(reminder));
    }

    public void deleteReminder(int reminderId, int userId) {
        reminderRepository.delete(getOwnedReminder(reminderId, userId));
    }

    private Reminder getOwnedReminder(int reminderId, int userId) {
        return reminderRepository.findById(reminderId)
                .filter(reminder -> reminder.getOwnerId() == userId)
                .orElseThrow(() -> new ResourceNotFoundException("Reminder not found with id: " + reminderId));
    }

    private ReminderResponse mapToResponse(Reminder reminder) {
        return ReminderResponse.builder()
                .reminderId(reminder.getReminderId())
                .message(reminder.getMessage())
                .reminderTime(reminder.getReminderTime())
                .completed(reminder.isCompleted())
                .processed(reminder.isProcessed())
                .noteId(reminder.getNoteId())
                .build();
    }
}
