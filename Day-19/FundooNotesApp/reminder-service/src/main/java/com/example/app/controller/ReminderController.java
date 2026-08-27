package com.example.app.controller;

import java.util.List;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import com.example.app.dto.ReminderRequest;
import com.example.app.dto.ReminderResponse;
import com.example.app.service.ReminderService;

@RestController
@RequestMapping("/reminders")
public class ReminderController {

    private final ReminderService reminderService;

    public ReminderController(ReminderService reminderService) {
        this.reminderService = reminderService;
    }

    private int currentUserId() {
        String userId = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return Integer.parseInt(userId);
    }

    @PostMapping
    public ResponseEntity<ReminderResponse> createReminder(@Valid @RequestBody ReminderRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(reminderService.createReminder(currentUserId(), request));
    }

    @GetMapping
    public ResponseEntity<List<ReminderResponse>> getMyReminders() {
        return ResponseEntity.ok(reminderService.getMyReminders(currentUserId()));
    }

    @PatchMapping("/{id}/complete")
    public ResponseEntity<ReminderResponse> markCompleted(@PathVariable int id) {
        return ResponseEntity.ok(reminderService.markCompleted(id, currentUserId()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReminder(@PathVariable int id) {
        reminderService.deleteReminder(id, currentUserId());
        return ResponseEntity.noContent().build();
    }
}
