package com.example.app.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.app.service.GreetingService;

@Component
public class User {
	
	private final GreetingService greetingService;
	
	@Autowired
	public User(GreetingService greetingService) {
		this.greetingService=greetingService;
	}
	
	public void welcome() {
		greetingService.greet();
	}
}
