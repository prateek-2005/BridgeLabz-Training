package com.example.app.dto;

import java.time.LocalDateTime;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NotificationResponse {

    private int notificationId;

    private String message;

    private boolean read;

    private LocalDateTime createdAt;
}
