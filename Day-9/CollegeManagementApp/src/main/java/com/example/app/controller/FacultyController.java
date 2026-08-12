package com.example.app.controller;

import com.example.app.entity.Faculty;
import com.example.app.service.FacultyService;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/faculty")
public class FacultyController {

	private final FacultyService facultyService;

	public FacultyController(FacultyService facultyService) {
		this.facultyService = facultyService;
	}

	@PostMapping
	public ResponseEntity<Faculty> createFaculty(@Valid @RequestBody Faculty faculty) {
		return ResponseEntity.status(HttpStatus.CREATED).body(facultyService.createFaculty(faculty));
	}

	@GetMapping
	public ResponseEntity<List<Faculty>> getAllFaculty() {
		return ResponseEntity.ok(facultyService.getAllFaculty());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Faculty> getFacultyById(@PathVariable Integer id) {
		return ResponseEntity.ok(facultyService.getFacultyById(id));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Faculty> updateFaculty(@PathVariable Integer id, @Valid @RequestBody Faculty faculty) {
		return ResponseEntity.ok(facultyService.updateFaculty(id, faculty));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteFaculty(@PathVariable Integer id) {
		facultyService.deleteFaculty(id);
		return ResponseEntity.noContent().build();
	}
}