package com.example.app.service;

import java.util.concurrent.TimeUnit;

import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.example.app.exception.RedisServiceException;

@Service
public class TokenService {

	private static final String TOKEN_PREFIX = "jwt:";

	private final RedisTemplate<String, String> redisTemplate;

	public TokenService(RedisTemplate<String, String> redisTemplate) {

		this.redisTemplate = redisTemplate;
	}

	public void saveToken(String token, long expirationMillis) {

		try {

			redisTemplate.opsForValue().set(TOKEN_PREFIX + token, "VALID", expirationMillis, TimeUnit.MILLISECONDS);

		} catch (DataAccessException e) {

			throw new RedisServiceException("Unable to save token in Redis", e);
		}
	}

	public boolean isTokenActive(String token) {

		try {

			return Boolean.TRUE.equals(redisTemplate.hasKey(TOKEN_PREFIX + token));

		} catch (DataAccessException e) {

			throw new RedisServiceException("Unable to check token in Redis", e);
		}
	}

	public void removeToken(String token) {

		try {

			redisTemplate.delete(TOKEN_PREFIX + token);

		} catch (DataAccessException e) {

			throw new RedisServiceException("Unable to remove token from Redis", e);
		}
	}
}