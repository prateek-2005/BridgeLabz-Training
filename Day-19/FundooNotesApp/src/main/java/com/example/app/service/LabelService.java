package com.example.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.app.dto.LabelRequest;
import com.example.app.dto.LabelResponse;
import com.example.app.entity.Label;
import com.example.app.entity.Note;
import com.example.app.entity.User;
import com.example.app.exception.DuplicateResourceException;
import com.example.app.exception.ResourceNotFoundException;
import com.example.app.repository.LabelRepository;
import com.example.app.repository.NoteRepository;
import com.example.app.repository.UserRepository;

@Service
public class LabelService {

	private final LabelRepository labelRepository;
	private final NoteRepository noteRepository;
	private final UserRepository userRepository;

	public LabelService(LabelRepository labelRepository, NoteRepository noteRepository, UserRepository userRepository) {

		this.labelRepository = labelRepository;
		this.noteRepository = noteRepository;
		this.userRepository = userRepository;
	}

	public LabelResponse createLabel(int userId, LabelRequest request) {

		User owner = getUser(userId);

		if (request.getName() == null || request.getName().trim().isEmpty()) {

			throw new IllegalArgumentException("Label name cannot be empty");
		}

		if (labelRepository.findByNameAndOwner(request.getName(), owner).isPresent()) {

			throw new DuplicateResourceException("Label already exists: " + request.getName());
		}

		Label label = Label.builder().name(request.getName()).owner(owner).build();

		return mapToResponse(labelRepository.save(label));
	}

	public List<LabelResponse> getMyLabels(int userId) {

		User owner = getUser(userId);

		return labelRepository.findByOwner(owner).stream().map(this::mapToResponse).toList();
	}

	public LabelResponse updateLabel(int labelId, int userId, LabelRequest request) {

		User owner = getUser(userId);

		Label label = getOwnedLabel(labelId, owner);

		if (request.getName() == null || request.getName().trim().isEmpty()) {

			throw new IllegalArgumentException("Label name cannot be empty");
		}

		if (!label.getName().equalsIgnoreCase(request.getName())
				&& labelRepository.findByNameAndOwner(request.getName(), owner).isPresent()) {

			throw new DuplicateResourceException("Label already exists: " + request.getName());
		}

		label.setName(request.getName());

		return mapToResponse(labelRepository.save(label));
	}

	public void deleteLabel(int labelId, int userId) {

		User owner = getUser(userId);

		Label label = getOwnedLabel(labelId, owner);

		for (Note note : label.getNotes()) {
			note.getLabels().remove(label);
		}

		labelRepository.delete(label);
	}

	public void addLabelToNote(int noteId, int labelId, int userId) {

		User owner = getUser(userId);

		Note note = noteRepository.findByNoteIdAndOwner(noteId, owner)
				.orElseThrow(() -> new ResourceNotFoundException("Note not found with id: " + noteId));

		Label label = getOwnedLabel(labelId, owner);

		note.getLabels().add(label);

		noteRepository.save(note);
	}

	public void removeLabelFromNote(int noteId, int labelId, int userId) {

		User owner = getUser(userId);

		Note note = noteRepository.findByNoteIdAndOwner(noteId, owner)
				.orElseThrow(() -> new ResourceNotFoundException("Note not found with id: " + noteId));

		Label label = getOwnedLabel(labelId, owner);

		note.getLabels().remove(label);

		noteRepository.save(note);
	}

	private User getUser(int userId) {

		return userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));
	}

	private Label getOwnedLabel(int labelId, User owner) {

		return labelRepository.findByLabelIdAndOwner(labelId, owner)
				.orElseThrow(() -> new ResourceNotFoundException("Label not found with id: " + labelId));
	}

	private LabelResponse mapToResponse(Label label) {

		return LabelResponse.builder().labelId(label.getLabelId()).name(label.getName()).build();
	}
}