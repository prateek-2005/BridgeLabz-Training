package com.example.app.dto;

import java.time.LocalDateTime;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReminderResponse {

    private int reminderId;
    private String message;
    private LocalDateTime reminderTime;
    private boolean completed;
    private boolean processed;
    private Integer noteId;
}
