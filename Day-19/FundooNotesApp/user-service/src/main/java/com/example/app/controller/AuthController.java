package com.example.app.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.example.app.dto.AuthResponse;
import com.example.app.dto.LoginRequest;
import com.example.app.dto.RegisterRequest;
import com.example.app.service.UserService;

@RestController
@RequestMapping("/auth")
public class AuthController {
	private final UserService userService;

	public AuthController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping("/register")
	public ResponseEntity<AuthResponse> register(@Valid @RequestBody RegisterRequest request) {
		String token = userService.register(request.getEmail(), request.getPassword(), request.getName());
		return ResponseEntity.status(HttpStatus.CREATED).body(new AuthResponse(token));
	}

	@PostMapping("/login")
	public ResponseEntity<AuthResponse> login(@Valid @RequestBody LoginRequest request) {
		String token = userService.login(request.getEmail(), request.getPassword());
		return ResponseEntity.ok(new AuthResponse(token));
	}
	
	@PostMapping("/logout")
	public ResponseEntity<String> logout(@RequestHeader("Authorization") String header){
		if(header==null || !header.startsWith("Bearer ")) {
			return ResponseEntity.badRequest().body("Invalid Authorization header");
		}
		String token=header.substring(7);
		userService.logout(token);
		return ResponseEntity.ok("Logged out successfully");
	}
	
}
