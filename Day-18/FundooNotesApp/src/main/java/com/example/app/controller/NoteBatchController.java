package com.example.app.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.multipart.MultipartFile;

import com.example.app.service.NoteBatchService;

@RestController
@RequestMapping("/notes/batch")
public class NoteBatchController {

	private final NoteBatchService noteBatchService;

	public NoteBatchController(NoteBatchService noteBatchService) {

		this.noteBatchService = noteBatchService;
	}

	private int currentUserId() {

		String userId = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		return Integer.parseInt(userId);
	}

	@PostMapping("/import")
	public ResponseEntity<?> importNotes(@RequestPart("file") MultipartFile file) {

		try {

			int userId = currentUserId();

			String message = noteBatchService.importNotes(file, userId);

			return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("message", message));

		} catch (IllegalArgumentException e) {

			return ResponseEntity.badRequest().body(Map.of("message", e.getMessage()));

		} catch (Exception e) {

			return ResponseEntity.internalServerError()
					.body(Map.of("message", "Failed to import notes", "error", e.getMessage()));
		}
	}
}