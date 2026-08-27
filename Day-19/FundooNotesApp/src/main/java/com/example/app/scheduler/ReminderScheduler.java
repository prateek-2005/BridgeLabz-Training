package com.example.app.scheduler;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.app.dto.ReminderMessage;
import com.example.app.entity.Reminder;
import com.example.app.messaging.ReminderProducer;
import com.example.app.repository.ReminderRepository;

@Component
public class ReminderScheduler {

    private final ReminderRepository reminderRepository;
    private final ReminderProducer reminderProducer;

    public ReminderScheduler(
            ReminderRepository reminderRepository,
            ReminderProducer reminderProducer) {

        this.reminderRepository = reminderRepository;
        this.reminderProducer = reminderProducer;
    }

    @Scheduled(fixedRate = 10000)
    public void processReminders() {

        List<Reminder> reminders =
                reminderRepository.findByReminderTimeLessThanEqualAndProcessedFalse(
                        LocalDateTime.now());

        for (Reminder reminder : reminders) {

            ReminderMessage message =
                    new ReminderMessage(
                            reminder.getReminderId(),
                            reminder.getOwner().getUserId(),
                            reminder.getMessage(),
                            reminder.getReminderTime()
                    );

            reminderProducer.sendReminder(message);

            reminder.setProcessed(true);
            reminderRepository.save(reminder);
        }
    }
}