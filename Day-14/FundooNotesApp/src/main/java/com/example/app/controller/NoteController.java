package com.example.app.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import com.example.app.dto.NoteRequest;
import com.example.app.dto.NoteResponse;
import com.example.app.service.NoteService;

@RestController
@RequestMapping("/notes")
public class NoteController {

	private final NoteService noteService;

	public NoteController(NoteService noteService) {
		this.noteService = noteService;
	}

	private int currentUserId() {

		String userId = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		return Integer.parseInt(userId);
	}

	@PostMapping
	public ResponseEntity<NoteResponse> createNote(@RequestBody NoteRequest request) {

		NoteResponse response = noteService.createNote(currentUserId(), request);

		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@GetMapping
	public ResponseEntity<List<NoteResponse>> getMyNotes() {

		List<NoteResponse> notes = noteService.getMyNotes(currentUserId());

		return ResponseEntity.ok(notes);
	}

	@PutMapping("/{id}")
	public ResponseEntity<NoteResponse> updateNote(@PathVariable int id, @RequestBody NoteRequest request) {

		NoteResponse response = noteService.updateNote(id, currentUserId(), request);

		return ResponseEntity.ok(response);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteNote(@PathVariable int id) {

		boolean deleted = noteService.deleteNote(id, currentUserId());

		if (!deleted) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.noContent().build();
	}
}
