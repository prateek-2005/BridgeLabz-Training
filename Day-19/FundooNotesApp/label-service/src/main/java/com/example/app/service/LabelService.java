package com.example.app.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.app.dto.LabelRequest;
import com.example.app.dto.LabelResponse;
import com.example.app.entity.Label;
import com.example.app.entity.NoteLabel;
import com.example.app.exception.DuplicateResourceException;
import com.example.app.exception.ResourceNotFoundException;
import com.example.app.repository.LabelRepository;
import com.example.app.repository.NoteLabelRepository;

@Service
public class LabelService {

	private final LabelRepository labelRepository;
	private final NoteLabelRepository noteLabelRepository;

	public LabelService(LabelRepository labelRepository, NoteLabelRepository noteLabelRepository) {

		this.labelRepository = labelRepository;
		this.noteLabelRepository = noteLabelRepository;
	}

	public LabelResponse createLabel(int userId, LabelRequest request) {

		if (request.getName() == null || request.getName().trim().isEmpty()) {

			throw new IllegalArgumentException("Label name cannot be empty");
		}

		if (labelRepository.findByNameAndOwnerId(request.getName(), userId).isPresent()) {

			throw new DuplicateResourceException("Label already exists: " + request.getName());
		}

		Label label = Label.builder().name(request.getName()).ownerId(userId).build();

		return mapToResponse(labelRepository.save(label));
	}

	public List<LabelResponse> getMyLabels(int userId) {

		return labelRepository.findByOwnerId(userId).stream().map(this::mapToResponse).toList();
	}

	public LabelResponse updateLabel(int labelId, int userId, LabelRequest request) {

		Label label = getOwnedLabel(labelId, userId);

		if (request.getName() == null || request.getName().trim().isEmpty()) {

			throw new IllegalArgumentException("Label name cannot be empty");
		}

		if (!label.getName().equalsIgnoreCase(request.getName())
				&& labelRepository.findByNameAndOwnerId(request.getName(), userId).isPresent()) {

			throw new DuplicateResourceException("Label already exists: " + request.getName());
		}

		label.setName(request.getName());

		return mapToResponse(labelRepository.save(label));
	}

	@Transactional
	public void deleteLabel(int labelId, int userId) {

		Label label = getOwnedLabel(labelId, userId);

		noteLabelRepository.deleteByLabelIdAndOwnerId(labelId, userId);

		labelRepository.delete(label);
	}

	public void addLabelToNote(int noteId, int labelId, int userId) {

		Label label = getOwnedLabel(labelId, userId);

		if (noteLabelRepository.findByNoteIdAndLabelIdAndOwnerId(noteId, label.getLabelId(), userId).isEmpty()) {
			NoteLabel noteLabel = NoteLabel.builder()
					.noteId(noteId)
					.labelId(label.getLabelId())
					.ownerId(userId)
					.build();
			noteLabelRepository.save(noteLabel);
		}
	}

	public void removeLabelFromNote(int noteId, int labelId, int userId) {

		Label label = getOwnedLabel(labelId, userId);

		noteLabelRepository.findByNoteIdAndLabelIdAndOwnerId(noteId, label.getLabelId(), userId)
				.ifPresent(noteLabelRepository::delete);
	}

	private Label getOwnedLabel(int labelId, int ownerId) {

		return labelRepository.findByLabelIdAndOwnerId(labelId, ownerId)
				.orElseThrow(() -> new ResourceNotFoundException("Label not found with id: " + labelId));
	}

	private LabelResponse mapToResponse(Label label) {

		return LabelResponse.builder().labelId(label.getLabelId()).name(label.getName()).build();
	}
}
