package com.example.app.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(
        name = "note_labels",
        uniqueConstraints = @UniqueConstraint(columnNames = {"note_id", "label_id", "user_id"})
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NoteLabel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "note_id", nullable = false)
    private int noteId;

    @Column(name = "label_id", nullable = false)
    private int labelId;

    @Column(name = "user_id", nullable = false)
    private int ownerId;
}
