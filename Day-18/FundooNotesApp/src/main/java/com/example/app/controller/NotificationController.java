package com.example.app.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import com.example.app.dto.NotificationResponse;
import com.example.app.service.NotificationService;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

	private final NotificationService notificationService;

	public NotificationController(NotificationService notificationService) {

		this.notificationService = notificationService;
	}

	private int currentUserId() {

		String userId = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		return Integer.parseInt(userId);
	}

	@GetMapping
	public ResponseEntity<List<NotificationResponse>> getNotifications() {

		return ResponseEntity.ok(notificationService.getMyNotifications(currentUserId()));
	}

	@PatchMapping("/{id}/read")
	public ResponseEntity<String> markAsRead(@PathVariable int id) {

		notificationService.markAsRead(id, currentUserId());

		return ResponseEntity.ok("Notification marked as read");
	}
}