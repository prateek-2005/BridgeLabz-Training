package com.example.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.app.dto.NoteRequest;
import com.example.app.dto.NoteResponse;
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

	public NoteResponse createNote(int userId, NoteRequest request) {

		User owner = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("User not found"));

		Note note = Note.builder().title(request.getTitle()).content(request.getContent()).owner(owner).build();

		Note savedNote = noteRepository.save(note);

		return mapToResponse(savedNote);
	}

	public List<NoteResponse> getMyNotes(int userId) {

		User owner = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("User not found"));

		return noteRepository.findByOwner(owner).stream().map(this::mapToResponse).toList();
	}

	public NoteResponse updateNote(int noteId, int userId, NoteRequest request) {

		User owner = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("User not found"));

		Note note = noteRepository.findByNoteIdAndOwner(noteId, owner)
				.orElseThrow(() -> new IllegalArgumentException("Note not found"));

		note.setTitle(request.getTitle());
		note.setContent(request.getContent());

		Note updatedNote = noteRepository.save(note);

		return mapToResponse(updatedNote);
	}

	public boolean deleteNote(int noteId, int requestingUserId) {

		User owner = userRepository.findById(requestingUserId)
				.orElseThrow(() -> new IllegalArgumentException("User not found"));

		return noteRepository.findByNoteIdAndOwner(noteId, owner).map(note -> {

			noteRepository.delete(note);

			return true;
		}).orElse(false);
	}

	private NoteResponse mapToResponse(Note note) {

		return NoteResponse.builder().noteId(note.getNoteId()).title(note.getTitle()).content(note.getContent())
				.build();
	}
}