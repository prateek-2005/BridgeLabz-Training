package com.example.app.service;

import org.springframework.stereotype.Component;

@Component
public class GreetingServiceImpl implements GreetingService {

    @Override
    public void greet() {
        System.out.println("Hello! Welcome to Core Spring.");
    }
}