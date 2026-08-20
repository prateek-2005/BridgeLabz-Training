package com.example.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.app.dto.LabelRequest;
import com.example.app.dto.LabelResponse;
import com.example.app.entity.Label;
import com.example.app.entity.Note;
import com.example.app.entity.User;
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

	// CREATE LABEL
	public LabelResponse createLabel(int userId, LabelRequest request) {

		User owner = getUser(userId);

		if (labelRepository.findByNameAndOwner(request.getName(), owner).isPresent()) {

			throw new IllegalArgumentException("Label already exists");
		}

		Label label = Label.builder().name(request.getName()).owner(owner).build();

		return mapToResponse(labelRepository.save(label));
	}

	// GET MY LABELS
	public List<LabelResponse> getMyLabels(int userId) {

		User owner = getUser(userId);

		return labelRepository.findByOwner(owner).stream().map(this::mapToResponse).toList();
	}

	// UPDATE LABEL
	public LabelResponse updateLabel(int labelId, int userId, LabelRequest request) {

		User owner = getUser(userId);

		Label label = getOwnedLabel(labelId, owner);

		label.setName(request.getName());

		return mapToResponse(labelRepository.save(label));
	}

	// DELETE LABEL
	public void deleteLabel(int labelId, int userId) {

		User owner = getUser(userId);

		Label label = getOwnedLabel(labelId, owner);

		for (Note note : label.getNotes()) {
			note.getLabels().remove(label);
		}

		labelRepository.delete(label);
	}

	// ADD LABEL TO NOTE
	public void addLabelToNote(int noteId, int labelId, int userId) {

		User owner = getUser(userId);

		Note note = noteRepository.findByNoteIdAndOwner(noteId, owner)
				.orElseThrow(() -> new IllegalArgumentException("Note not found"));

		Label label = getOwnedLabel(labelId, owner);

		note.getLabels().add(label);

		noteRepository.save(note);
	}

	// REMOVE LABEL FROM NOTE
	public void removeLabelFromNote(int noteId, int labelId, int userId) {

		User owner = getUser(userId);

		Note note = noteRepository.findByNoteIdAndOwner(noteId, owner)
				.orElseThrow(() -> new IllegalArgumentException("Note not found"));

		Label label = getOwnedLabel(labelId, owner);

		note.getLabels().remove(label);

		noteRepository.save(note);
	}

	private User getUser(int userId) {

		return userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("User not found"));
	}

	private Label getOwnedLabel(int labelId, User owner) {

		return labelRepository.findByLabelIdAndOwner(labelId, owner)
				.orElseThrow(() -> new IllegalArgumentException("Label not found"));
	}

	private LabelResponse mapToResponse(Label label) {

		return LabelResponse.builder().labelId(label.getLabelId()).name(label.getName()).build();
	}
}