package com.example.app.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "reminders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reminder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reminderId;

    @Column(nullable = false)
    private String message;

    @Column(nullable = false)
    private LocalDateTime reminderTime;

    @Column(nullable = false)
    @Builder.Default
    private boolean completed = false;

    @Column(name = "user_id", nullable = false)
    private int ownerId;

    @Column(name = "note_id")
    private Integer noteId;
    
    @Column(nullable = false)
    private boolean processed = false;
}
