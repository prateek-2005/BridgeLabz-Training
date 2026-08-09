package com.example.app.service;

import java.util.List;

import com.example.app.model.Greeting;
import com.example.app.repository.GreetingRepository;

public class GreetingService {

    private final GreetingRepository repository;

    public GreetingService(GreetingRepository repository) {
        this.repository = repository;
    }

    public Greeting create(String message) {
        return repository.save(message);
    }

    public List<Greeting> getAll() {
        return repository.findAll();
    }

    public Greeting getById(int id) {
        return repository.findById(id);
    }

    public boolean update(int id, String message) {
        return repository.update(id, message);
    }

    public boolean delete(int id) {
        return repository.delete(id);
    }
}