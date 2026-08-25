package com.example.app.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.app.dto.NotificationResponse;
import com.example.app.entity.Notification;
import com.example.app.entity.User;
import com.example.app.repository.NotificationRepository;
import com.example.app.repository.UserRepository;

@Service
public class NotificationService {

	private final NotificationRepository notificationRepository;
	private final UserRepository userRepository;

	public NotificationService(NotificationRepository notificationRepository, UserRepository userRepository) {

		this.notificationRepository = notificationRepository;

		this.userRepository = userRepository;
	}

	public List<NotificationResponse> getMyNotifications(int userId) {

		User owner = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("User not found"));

		return notificationRepository.findByOwnerOrderByCreatedAtDesc(owner).stream().map(this::mapToResponse).toList();
	}

	public void markAsRead(int notificationId, int userId) {

		User owner = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("User not found"));

		Notification notification = notificationRepository.findById(notificationId)
				.orElseThrow(() -> new IllegalArgumentException("Notification not found"));

		if (notification.getOwner().getUserId() != userId) {

			throw new IllegalArgumentException("Notification does not belong to user");
		}

		notification.setRead(true);

		notificationRepository.save(notification);
	}

	private NotificationResponse mapToResponse(Notification notification) {

		return NotificationResponse.builder().notificationId(notification.getNotificationId())
				.message(notification.getMessage()).read(notification.isRead()).createdAt(notification.getCreatedAt())
				.build();
	}

	public Notification createNotification(int userId, String message) {

		User user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("User not found"));

		Notification notification = new Notification();

		notification.setOwner(user);
		notification.setMessage(message);
		notification.setRead(false);
		notification.setCreatedAt(LocalDateTime.now());

		return notificationRepository.save(notification);
	}
}
