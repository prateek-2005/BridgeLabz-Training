package com.example.app.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import com.example.app.dto.LabelRequest;
import com.example.app.dto.LabelResponse;
import com.example.app.service.LabelService;

@RestController
@RequestMapping("/labels")
public class LabelController {

    private final LabelService labelService;

    public LabelController(LabelService labelService) {
        this.labelService = labelService;
    }

    private int currentUserId() {

        String userId = (String)
                SecurityContextHolder
                        .getContext()
                        .getAuthentication()
                        .getPrincipal();

        return Integer.parseInt(userId);
    }

    // CREATE
    @PostMapping
    public ResponseEntity<LabelResponse> createLabel(
            @RequestBody LabelRequest request) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(labelService.createLabel(
                        currentUserId(),
                        request));
    }

    // READ
    @GetMapping
    public ResponseEntity<List<LabelResponse>> getMyLabels() {

        return ResponseEntity.ok(
                labelService.getMyLabels(
                        currentUserId()));
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<LabelResponse> updateLabel(
            @PathVariable int id,
            @RequestBody LabelRequest request) {

        return ResponseEntity.ok(
                labelService.updateLabel(
                        id,
                        currentUserId(),
                        request));
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLabel(
            @PathVariable int id) {

        labelService.deleteLabel(
                id,
                currentUserId());

        return ResponseEntity
                .noContent()
                .build();
    }

    // ADD LABEL TO NOTE
    @PostMapping("/{labelId}/notes/{noteId}")
    public ResponseEntity<String> addLabelToNote(
            @PathVariable int labelId,
            @PathVariable int noteId) {

        labelService.addLabelToNote(
                noteId,
                labelId,
                currentUserId());

        return ResponseEntity.ok(
                "Label added to note");
    }

    // REMOVE LABEL FROM NOTE
    @DeleteMapping("/{labelId}/notes/{noteId}")
    public ResponseEntity<String> removeLabelFromNote(
            @PathVariable int labelId,
            @PathVariable int noteId) {

        labelService.removeLabelFromNote(
                noteId,
                labelId,
                currentUserId());

        return ResponseEntity.ok(
                "Label removed from note");
    }
}
