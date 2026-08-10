package com.example.app.service;

import com.example.app.entity.Contact;
import com.example.app.exception.ContactNotFoundException;
import com.example.app.repository.ContactRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContactService {

	private final ContactRepository repository;

	public Contact createContact(Contact contact) {
		return repository.save(contact);
	}

	public List<Contact> getAllContacts() {
		return repository.findAll();
	}

	public Contact getContactById(Long id) {
		return repository.findById(id).orElseThrow(() -> new ContactNotFoundException(id));
	}

	public Contact updateContact(Long id, Contact updatedContact) {
		Contact existingContact = getContactById(id);
		existingContact.setName(updatedContact.getName());
		existingContact.setPhone(updatedContact.getPhone());
		existingContact.setEmail(updatedContact.getEmail());
		existingContact.setAddress(updatedContact.getAddress());
		return repository.save(existingContact);
	}

	public void deleteContact(Long id) {
		Contact contact = getContactById(id);
		repository.delete(contact);
	}
}