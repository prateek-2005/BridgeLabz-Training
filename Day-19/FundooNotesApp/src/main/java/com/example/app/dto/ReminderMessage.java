package com.example.app.dto;

import java.time.LocalDateTime;

public class ReminderMessage {

    private int reminderId;
    private int userId;
    private String message;
    private LocalDateTime reminderTime;

    public ReminderMessage() {
    }

    public ReminderMessage(
            int reminderId,
            int userId,
            String message,
            LocalDateTime reminderTime) {

        this.reminderId = reminderId;
        this.userId = userId;
        this.message = message;
        this.reminderTime = reminderTime;
    }

    public int getReminderId() {
        return reminderId;
    }

    public void setReminderId(int reminderId) {
        this.reminderId = reminderId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getReminderTime() {
        return reminderTime;
    }

    public void setReminderTime(LocalDateTime reminderTime) {
        this.reminderTime = reminderTime;
    }
}