package com.example.app.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReminderRequest {

    @NotBlank(message = "Reminder message is required")
    private String message;

    @NotNull(message = "Reminder time is required")
    @Future(message = "Reminder time must be in the future")
    private LocalDateTime reminderTime;

    private Integer noteId;
}
