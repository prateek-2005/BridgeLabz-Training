package com.example.app.service;

import java.util.concurrent.TimeUnit;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class TokenService {

	private static final String TOKEN_PREFIX = "jwt:";

	private final RedisTemplate<String, String> redisTemplate;

	public TokenService(RedisTemplate<String, String> redisTemplate) {

		this.redisTemplate = redisTemplate;
	}

	public void saveToken(String token, long expirationMillis) {

		redisTemplate.opsForValue().set(TOKEN_PREFIX + token, "VALID", expirationMillis, TimeUnit.MILLISECONDS);
	}

	public boolean isTokenActive(String token) {

		return Boolean.TRUE.equals(redisTemplate.hasKey(TOKEN_PREFIX + token));
	}

	public void removeToken(String token) {

		redisTemplate.delete(TOKEN_PREFIX + token);
	}
}