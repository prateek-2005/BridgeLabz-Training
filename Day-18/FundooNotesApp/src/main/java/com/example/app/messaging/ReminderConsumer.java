package com.example.app.messaging;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.example.app.config.RabbitMQConfig;
import com.example.app.dto.ReminderMessage;
import com.example.app.service.NotificationService;

@Component
public class ReminderConsumer {

    private final NotificationService notificationService;

    public ReminderConsumer(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @RabbitListener(queues = RabbitMQConfig.REMINDER_QUEUE)
    public void consumeReminder(ReminderMessage message) {

        notificationService.createNotification(
                message.getUserId(),
                message.getMessage()
        );
    }
}