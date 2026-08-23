package com.example.app.messaging;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class ReminderProducer {

    private static final String QUEUE =
            "fundoo.reminders";

    private final JmsTemplate jmsTemplate;

    public ReminderProducer(
            JmsTemplate jmsTemplate) {

        this.jmsTemplate = jmsTemplate;
    }

    public void sendReminder(
            ReminderMessage message) {

        jmsTemplate.convertAndSend(
                QUEUE,
                message);
    }
}
