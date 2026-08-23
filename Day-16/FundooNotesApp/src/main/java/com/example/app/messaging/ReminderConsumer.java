package com.example.app.messaging;

import java.time.LocalDateTime;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.example.app.entity.Notification;
import com.example.app.entity.User;
import com.example.app.repository.NotificationRepository;
import com.example.app.repository.UserRepository;

@Component
public class ReminderConsumer {

	private final NotificationRepository notificationRepository;
	private final UserRepository userRepository;

	public ReminderConsumer(NotificationRepository notificationRepository, UserRepository userRepository) {

		this.notificationRepository = notificationRepository;

		this.userRepository = userRepository;
	}

	@JmsListener(destination = "fundoo.reminders")
	public void consumeReminder(ReminderMessage message) {

		User user = userRepository.findById(message.getUserId()).orElse(null);

		if (user == null) {
			return;
		}

		Notification notification = Notification.builder().message("Reminder: " + message.getMessage()).read(false)
				.createdAt(LocalDateTime.now()).owner(user).build();

		notificationRepository.save(notification);
	}
}
