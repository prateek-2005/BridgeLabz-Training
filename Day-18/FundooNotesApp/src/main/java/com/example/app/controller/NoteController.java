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

	// CREATE
	@PostMapping
	public ResponseEntity<NoteResponse> createNote(@RequestBody NoteRequest request) {

		return ResponseEntity.status(HttpStatus.CREATED).body(noteService.createNote(currentUserId(), request));
	}

	// READ ACTIVE NOTES
	@GetMapping
	public ResponseEntity<List<NoteResponse>> getMyNotes() {

		return ResponseEntity.ok(noteService.getMyNotes(currentUserId()));
	}

	// UPDATE
	@PutMapping("/{id}")
	public ResponseEntity<NoteResponse> updateNote(@PathVariable int id, @RequestBody NoteRequest request) {

		return ResponseEntity.ok(noteService.updateNote(id, currentUserId(), request));
	}

	// PIN / UNPIN
	@PatchMapping("/{id}/pin")
	public ResponseEntity<String> togglePin(@PathVariable int id) {

		boolean pinned = noteService.togglePin(id, currentUserId());

		return ResponseEntity.ok(pinned ? "Note pinned" : "Note unpinned");
	}

	// ARCHIVE / UNARCHIVE
	@PatchMapping("/{id}/archive")
	public ResponseEntity<String> toggleArchive(@PathVariable int id) {

		boolean archived = noteService.toggleArchive(id, currentUserId());

		return ResponseEntity.ok(archived ? "Note archived" : "Note unarchived");
	}

	// MOVE TO TRASH
	@PatchMapping("/{id}/trash")
	public ResponseEntity<String> moveToTrash(@PathVariable int id) {

		noteService.moveToTrash(id, currentUserId());

		return ResponseEntity.ok("Note moved to trash");
	}

	// RESTORE
	@PatchMapping("/{id}/restore")
	public ResponseEntity<String> restoreNote(@PathVariable int id) {

		noteService.restoreNote(id, currentUserId());

		return ResponseEntity.ok("Note restored");
	}

	// PERMANENT DELETE
	@DeleteMapping("/{id}/permanent")
	public ResponseEntity<Void> permanentlyDelete(@PathVariable int id) {

		noteService.permanentlyDelete(id, currentUserId());

		return ResponseEntity.noContent().build();
	}

	// PINNED
	@GetMapping("/pinned")
	public ResponseEntity<List<NoteResponse>> getPinnedNotes() {

		return ResponseEntity.ok(noteService.getPinnedNotes(currentUserId()));
	}

	// ARCHIVED
	@GetMapping("/archived")
	public ResponseEntity<List<NoteResponse>> getArchivedNotes() {

		return ResponseEntity.ok(noteService.getArchivedNotes(currentUserId()));
	}

	// TRASH
	@GetMapping("/trash")
	public ResponseEntity<List<NoteResponse>> getTrashNotes() {

		return ResponseEntity.ok(noteService.getTrashNotes(currentUserId()));
	}

	// SEARCH
	@GetMapping("/search")
	public ResponseEntity<List<NoteResponse>> searchNotes(@RequestParam String keyword) {

		return ResponseEntity.ok(noteService.searchNotes(currentUserId(), keyword));
	}
}