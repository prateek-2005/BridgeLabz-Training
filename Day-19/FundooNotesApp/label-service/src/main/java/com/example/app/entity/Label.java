package com.example.app.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "labels")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Label {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int labelId;

    @Column(nullable = false)
    private String name;

    @Column(name = "user_id", nullable = false)
    private int ownerId;

}
