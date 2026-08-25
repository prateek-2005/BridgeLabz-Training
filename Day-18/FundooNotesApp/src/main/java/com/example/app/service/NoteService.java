package com.example.app.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.app.dto.NoteRequest;
import com.example.app.dto.NoteResponse;
import com.example.app.entity.Label;
import com.example.app.entity.Note;
import com.example.app.entity.User;
import com.example.app.repository.NoteRepository;
import com.example.app.repository.UserRepository;

@Service
public class NoteService {

	private final NoteRepository noteRepository;
	private final UserRepository userRepository;

	public NoteService(NoteRepository noteRepository, UserRepository userRepository) {

		this.noteRepository = noteRepository;
		this.userRepository = userRepository;
	}

	// CREATE
	public NoteResponse createNote(int userId, NoteRequest request) {

		User owner = getUser(userId);

		Note note = Note.builder().title(request.getTitle()).content(request.getContent()).owner(owner).pinned(false)
				.archived(false).trashed(false).build();

		return mapToResponse(noteRepository.save(note));
	}

	// READ MY NOTES
	public List<NoteResponse> getMyNotes(int userId) {

		User owner = getUser(userId);

		return noteRepository.findByOwnerAndTrashedFalseAndArchivedFalse(owner).stream().map(this::mapToResponse)
				.toList();
	}

	// UPDATE
	public NoteResponse updateNote(int noteId, int userId, NoteRequest request) {

		User owner = getUser(userId);

		Note note = getOwnedNote(noteId, owner);

		note.setTitle(request.getTitle());
		note.setContent(request.getContent());

		return mapToResponse(noteRepository.save(note));
	}

	// DELETE / TRASH
	public boolean moveToTrash(int noteId, int userId) {

		User owner = getUser(userId);

		Note note = getOwnedNote(noteId, owner);

		note.setTrashed(true);

		noteRepository.save(note);

		return true;
	}

	// RESTORE FROM TRASH
	public boolean restoreNote(int noteId, int userId) {

		User owner = getUser(userId);

		Note note = getOwnedNote(noteId, owner);

		note.setTrashed(false);

		noteRepository.save(note);

		return true;
	}

	// PERMANENT DELETE
	public boolean permanentlyDelete(int noteId, int userId) {

		User owner = getUser(userId);

		Note note = getOwnedNote(noteId, owner);

		noteRepository.delete(note);

		return true;
	}

	// PIN
	public boolean togglePin(int noteId, int userId) {

		User owner = getUser(userId);

		Note note = getOwnedNote(noteId, owner);

		note.setPinned(!note.isPinned());

		noteRepository.save(note);

		return note.isPinned();
	}

	// ARCHIVE
	public boolean toggleArchive(int noteId, int userId) {

		User owner = getUser(userId);

		Note note = getOwnedNote(noteId, owner);

		note.setArchived(!note.isArchived());

		noteRepository.save(note);

		return note.isArchived();
	}

	// GET PINNED
	public List<NoteResponse> getPinnedNotes(int userId) {

		User owner = getUser(userId);

		return noteRepository.findByOwnerAndPinnedTrue(owner).stream().filter(note -> !note.isTrashed())
				.map(this::mapToResponse).toList();
	}

	// GET ARCHIVED
	public List<NoteResponse> getArchivedNotes(int userId) {

		User owner = getUser(userId);

		return noteRepository.findByOwnerAndArchivedTrue(owner).stream().filter(note -> !note.isTrashed())
				.map(this::mapToResponse).toList();
	}

	// GET TRASH
	public List<NoteResponse> getTrashNotes(int userId) {

		User owner = getUser(userId);

		return noteRepository.findByOwnerAndTrashedTrue(owner).stream().map(this::mapToResponse).toList();
	}

	// SEARCH
	public List<NoteResponse> searchNotes(int userId, String keyword) {

		User owner = getUser(userId);

		return noteRepository
				.findByOwnerAndTitleContainingIgnoreCaseOrOwnerAndContentContainingIgnoreCase(owner, keyword, owner,
						keyword)
				.stream().filter(note -> !note.isTrashed() && !note.isArchived()).map(this::mapToResponse).toList();
	}

	// GET BY LABEL
	public List<NoteResponse> getNotesByLabel(int userId, Label label) {

		User owner = getUser(userId);

		return noteRepository.findByOwnerAndLabelsContaining(owner, label).stream().filter(note -> !note.isTrashed())
				.map(this::mapToResponse).toList();
	}

	private User getUser(int userId) {

		return userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("User not found"));
	}

	private Note getOwnedNote(int noteId, User owner) {

		return noteRepository.findByNoteIdAndOwner(noteId, owner)
				.orElseThrow(() -> new IllegalArgumentException("Note not found"));
	}

	private NoteResponse mapToResponse(Note note) {

		Set<String> labels = note.getLabels().stream().map(Label::getName).collect(Collectors.toSet());

		return NoteResponse.builder().noteId(note.getNoteId()).title(note.getTitle()).content(note.getContent())
				.pinned(note.isPinned()).archived(note.isArchived()).trashed(note.isTrashed()).labels(labels).build();
	}
}