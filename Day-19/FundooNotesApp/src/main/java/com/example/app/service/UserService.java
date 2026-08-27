package com.example.app.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.app.entity.User;
import com.example.app.exception.DuplicateResourceException;
import com.example.app.exception.UnauthorizedException;
import com.example.app.repository.UserRepository;
import com.example.app.security.JwtUtil;

@Service
public class UserService {

	private final UserRepository userRepository;
	private final JwtUtil jwtUtil;
	private final TokenService tokenService;

	private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	public UserService(UserRepository userRepository, JwtUtil jwtUtil, TokenService tokenService) {

		this.userRepository = userRepository;
		this.jwtUtil = jwtUtil;
		this.tokenService = tokenService;
	}

	public String register(String email, String password, String name) {

		if (userRepository.findByEmail(email).isPresent()) {
			throw new DuplicateResourceException("Email already registered");
		}

		User user = new User();

		user.setEmail(email);
		user.setPasswordHash(passwordEncoder.encode(password));
		user.setName(name);

		User saved = userRepository.save(user);

		String token = jwtUtil.generateToken(String.valueOf(saved.getUserId()), saved.getEmail());

		tokenService.saveToken(token, jwtUtil.getExpirationMillis());

		return token;
	}

	public String login(String email, String password) {

		User user = userRepository.findByEmail(email)
				.orElseThrow(() -> new UnauthorizedException("Invalid email or password"));

		if (!passwordEncoder.matches(password, user.getPasswordHash())) {
			throw new UnauthorizedException("Invalid email or password");
		}

		String token = jwtUtil.generateToken(String.valueOf(user.getUserId()), user.getEmail());

		tokenService.saveToken(token, jwtUtil.getExpirationMillis());

		return token;
	}

	public void logout(String token) {

		tokenService.removeToken(token);
	}

}