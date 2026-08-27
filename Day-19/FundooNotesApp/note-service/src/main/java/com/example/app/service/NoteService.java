package com.example.app.service;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.app.dto.NoteRequest;
import com.example.app.dto.NoteResponse;
import com.example.app.entity.Note;
import com.example.app.exception.ResourceNotFoundException;
import com.example.app.repository.NoteRepository;

@Service
public class NoteService {

	private final NoteRepository noteRepository;

	public NoteService(NoteRepository noteRepository) {

		this.noteRepository = noteRepository;
	}

	public NoteResponse createNote(int userId, NoteRequest request) {

		Note note = Note.builder().title(request.getTitle()).content(request.getContent()).ownerId(userId).pinned(false)
				.archived(false).trashed(false).build();

		Note savedNote = noteRepository.save(note);

		return mapToResponse(savedNote);
	}

	public List<NoteResponse> getMyNotes(int userId) {

		return noteRepository.findByOwnerIdAndTrashedFalseAndArchivedFalse(userId).stream().map(this::mapToResponse)
				.toList();
	}

	public NoteResponse updateNote(int noteId, int userId, NoteRequest request) {

		Note note = getOwnedNote(noteId, userId);

		note.setTitle(request.getTitle());
		note.setContent(request.getContent());

		Note updatedNote = noteRepository.save(note);

		return mapToResponse(updatedNote);
	}

	public boolean moveToTrash(int noteId, int userId) {

		Note note = getOwnedNote(noteId, userId);

		note.setTrashed(true);

		noteRepository.save(note);

		return true;
	}

	public boolean restoreNote(int noteId, int userId) {

		Note note = getOwnedNote(noteId, userId);

		note.setTrashed(false);

		noteRepository.save(note);

		return true;
	}

	public boolean permanentlyDelete(int noteId, int userId) {

		Note note = getOwnedNote(noteId, userId);

		noteRepository.delete(note);

		return true;
	}

	public boolean togglePin(int noteId, int userId) {

		Note note = getOwnedNote(noteId, userId);

		note.setPinned(!note.isPinned());

		noteRepository.save(note);

		return note.isPinned();
	}

	public boolean toggleArchive(int noteId, int userId) {

		Note note = getOwnedNote(noteId, userId);

		note.setArchived(!note.isArchived());

		noteRepository.save(note);

		return note.isArchived();
	}

	// =========================
	// GET PINNED NOTES
	// =========================

	public List<NoteResponse> getPinnedNotes(int userId) {

		return noteRepository.findByOwnerIdAndPinnedTrue(userId).stream()
				.filter(note -> !note.isTrashed() && !note.isArchived()).map(this::mapToResponse).toList();
	}

	public List<NoteResponse> getArchivedNotes(int userId) {

		return noteRepository.findByOwnerIdAndArchivedTrue(userId).stream().filter(note -> !note.isTrashed())
				.map(this::mapToResponse).toList();
	}

	public List<NoteResponse> getTrashNotes(int userId) {

		return noteRepository.findByOwnerIdAndTrashedTrue(userId).stream().map(this::mapToResponse).toList();
	}

	public List<NoteResponse> searchNotes(int userId, String keyword) {

		return noteRepository
				.findByOwnerIdAndTitleContainingIgnoreCaseOrOwnerIdAndContentContainingIgnoreCase(userId, keyword, userId,
						keyword)
				.stream().filter(note -> !note.isTrashed() && !note.isArchived()).map(this::mapToResponse).toList();
	}

	private Note getOwnedNote(int noteId, int ownerId) {

		return noteRepository.findByNoteIdAndOwnerId(noteId, ownerId)
				.orElseThrow(() -> new ResourceNotFoundException("Note not found"));
	}

	private NoteResponse mapToResponse(Note note) {

		return NoteResponse.builder().noteId(note.getNoteId()).title(note.getTitle()).content(note.getContent())
				.pinned(note.isPinned()).archived(note.isArchived()).trashed(note.isTrashed()).labels(Collections.emptySet()).build();
	}
}
