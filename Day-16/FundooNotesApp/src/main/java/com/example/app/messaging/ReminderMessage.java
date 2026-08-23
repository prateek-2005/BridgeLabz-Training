package com.example.app.messaging;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReminderMessage implements Serializable {

    private int userId;

    private String message;

    private LocalDateTime reminderTime;
}