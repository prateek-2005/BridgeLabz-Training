package com.example.app.dto;

import java.util.Set;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NoteResponse {

    private int noteId;

    private String title;

    private String content;

    private boolean pinned;

    private boolean archived;

    private boolean trashed;

    private Set<String> labels;
}
