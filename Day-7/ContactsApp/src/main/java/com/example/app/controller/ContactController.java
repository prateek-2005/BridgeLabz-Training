package com.example.app.controller;

import com.example.app.entity.Contact;
import com.example.app.service.ContactService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contacts")
@RequiredArgsConstructor
public class ContactController {

	private final ContactService service;

	@PostMapping
	public ResponseEntity<Contact> createContact(@RequestBody Contact contact) {
		Contact savedContact = service.createContact(contact);
		return new ResponseEntity<>(savedContact, HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<Contact>> getAllContacts() {
		return ResponseEntity.ok(service.getAllContacts());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Contact> getContactById(@PathVariable Long id) {
		return ResponseEntity.ok(service.getContactById(id));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Contact> updateContact(@PathVariable Long id, @RequestBody Contact contact) {
		return ResponseEntity.ok(service.updateContact(id, contact));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteContact(@PathVariable Long id) {
		service.deleteContact(id);
		return ResponseEntity.noContent().build();
	}
}