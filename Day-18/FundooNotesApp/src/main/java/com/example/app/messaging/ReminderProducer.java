package com.example.app.messaging;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import com.example.app.config.RabbitMQConfig;
import com.example.app.dto.ReminderMessage;

@Component
public class ReminderProducer {

    private final RabbitTemplate rabbitTemplate;

    public ReminderProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendReminder(ReminderMessage message) {

        rabbitTemplate.convertAndSend(
                RabbitMQConfig.REMINDER_EXCHANGE,
                RabbitMQConfig.REMINDER_ROUTING_KEY,
                message
        );
    }
}