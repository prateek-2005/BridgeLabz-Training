package com.example.app.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.app.dto.NotificationResponse;
import com.example.app.entity.Notification;
import com.example.app.exception.ResourceNotFoundException;
import com.example.app.exception.UnauthorizedException;
import com.example.app.repository.NotificationRepository;

@Service
public class NotificationService {

	private final NotificationRepository notificationRepository;

	public NotificationService(NotificationRepository notificationRepository) {

		this.notificationRepository = notificationRepository;
	}

	public List<NotificationResponse> getMyNotifications(int userId) {

		return notificationRepository.findByOwnerIdOrderByCreatedAtDesc(userId).stream().map(this::mapToResponse).toList();
	}

	public void markAsRead(int notificationId, int userId) {

		Notification notification = notificationRepository.findById(notificationId)
				.orElseThrow(() -> new ResourceNotFoundException("Notification not found with id: " + notificationId));

		if (notification.getOwnerId() != userId) {

			throw new UnauthorizedException("You are not authorized to access this notification");
		}

		notification.setRead(true);

		notificationRepository.save(notification);
	}

	public Notification createNotification(int userId, String message) {

		if (message == null || message.trim().isEmpty()) {

			throw new IllegalArgumentException("Notification message cannot be empty");
		}

		Notification notification = new Notification();

		notification.setOwnerId(userId);
		notification.setMessage(message);
		notification.setRead(false);
		notification.setCreatedAt(LocalDateTime.now());

		return notificationRepository.save(notification);
	}

	private NotificationResponse mapToResponse(Notification notification) {

		return NotificationResponse.builder().notificationId(notification.getNotificationId())
				.message(notification.getMessage()).read(notification.isRead()).createdAt(notification.getCreatedAt())
				.build();
	}
}
