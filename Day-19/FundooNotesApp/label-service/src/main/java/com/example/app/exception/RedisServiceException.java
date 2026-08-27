package com.example.app.exception;

public class RedisServiceException extends RuntimeException {

    public RedisServiceException(String message) {
        super(message);
    }

    public RedisServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}