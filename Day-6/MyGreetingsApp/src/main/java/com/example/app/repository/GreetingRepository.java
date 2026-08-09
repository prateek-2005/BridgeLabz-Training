package com.example.app.repository;
import com.example.app.model.Greeting;

import java.util.ArrayList;
import java.util.List;

public class GreetingRepository {

    private final List<Greeting> greetings = new ArrayList<>();

    private int nextId = 1;

    public GreetingRepository() {
        greetings.add(new Greeting(nextId++, "Hello World"));
        greetings.add(new Greeting(nextId++, "Welcome to Spring MVC"));
        greetings.add(new Greeting(nextId++, "Welcome to Tomcat"));
    }

    // CREATE
    public Greeting save(String message) {

        Greeting greeting = new Greeting(nextId++, message);

        greetings.add(greeting);

        return greeting;
    }

    // READ ALL
    public List<Greeting> findAll() {
        return greetings;
    }

    // READ ONE
    
    public Greeting findById(int id) {

        return greetings.stream()
                .filter(g -> g.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // UPDATE
    public boolean update(int id, String message) {

        Greeting greeting = findById(id);

        if (greeting == null) {
            return false;
        }

        greeting.setMessage(message);

        return true;
    }

    // DELETE
    public boolean delete(int id) {

        return greetings.removeIf(g -> g.getId() == id);
    }
}