package com.example.app.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "notes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int noteId;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    @Column(nullable = false)
    @Builder.Default
    private boolean pinned = false;

    @Column(nullable = false)
    @Builder.Default
    private boolean archived = false;

    @Column(nullable = false)
    @Builder.Default
    private boolean trashed = false;

    @Column(name = "user_id", nullable = false)
    private int ownerId;

}
