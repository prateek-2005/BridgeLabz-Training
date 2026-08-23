package com.example.app.dto;

import java.time.LocalDateTime;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReminderRequest {

    @NotBlank
    private String message;

    @NotNull
    private LocalDateTime reminderTime;

    private Integer noteId;
}