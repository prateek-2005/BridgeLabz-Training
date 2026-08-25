package com.example.app.security;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {
	private final SecretKey secretKey = Keys
			.hmacShaKeyFor("ThisIsASecretKeyThatShouldBeAtLeast256BitsLongForHS256".getBytes());
	private final long expirationMillis = 1000 * 60 * 60; // 1 hour

	public String generateToken(String userId, String email) {
		return Jwts.builder().subject(userId).claim("email", email).issuedAt(new Date(System.currentTimeMillis()))
				.expiration(new Date(System.currentTimeMillis() + expirationMillis)).signWith(secretKey).compact();
	}

	public String extractUserId(String token) {
		return Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(token).getPayload().getSubject();
	}

	public boolean isTokenValid(String token) {
		try {
			Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(token);
			return true;
		} catch (Exception e) {

			return false;
		}
	}
	

	public long getExpirationMillis() {
		return expirationMillis;
	}
}
