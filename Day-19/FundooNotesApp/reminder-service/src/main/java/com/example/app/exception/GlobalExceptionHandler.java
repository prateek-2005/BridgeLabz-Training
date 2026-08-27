package com.example.app.exception;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleResourceNotFound(ResourceNotFoundException ex,
			HttpServletRequest request) {

		return buildResponse(HttpStatus.NOT_FOUND, ex.getMessage(), request.getRequestURI());
	}

	@ExceptionHandler(UnauthorizedException.class)
	public ResponseEntity<ErrorResponse> handleUnauthorized(UnauthorizedException ex, HttpServletRequest request) {

		return buildResponse(HttpStatus.UNAUTHORIZED, ex.getMessage(), request.getRequestURI());
	}

	@ExceptionHandler(DuplicateResourceException.class)
	public ResponseEntity<ErrorResponse> handleDuplicateResource(DuplicateResourceException ex,
			HttpServletRequest request) {

		return buildResponse(HttpStatus.CONFLICT, ex.getMessage(), request.getRequestURI());
	}

	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<ErrorResponse> handleIllegalArgument(IllegalArgumentException ex,
			HttpServletRequest request) {

		return buildResponse(HttpStatus.BAD_REQUEST, ex.getMessage(), request.getRequestURI());
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponse> handleValidation(MethodArgumentNotValidException ex,
			HttpServletRequest request) {

		String message = ex.getBindingResult().getFieldErrors().stream()
				.map(error -> error.getField() + ": " + error.getDefaultMessage()).collect(Collectors.joining(", "));

		return buildResponse(HttpStatus.BAD_REQUEST, message, request.getRequestURI());
	}

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<ErrorResponse> handleConstraintViolation(ConstraintViolationException ex,
			HttpServletRequest request) {

		return buildResponse(HttpStatus.BAD_REQUEST, ex.getMessage(), request.getRequestURI());
	}

	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<ErrorResponse> handleDatabaseError(DataIntegrityViolationException ex,
			HttpServletRequest request) {

		return buildResponse(HttpStatus.CONFLICT, "Database constraint violation", request.getRequestURI());
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleGeneralException(Exception ex, HttpServletRequest request) {

		ex.printStackTrace();

		return buildResponse(HttpStatus.INTERNAL_SERVER_ERROR, "An unexpected error occurred", request.getRequestURI());
	}

	/*
	 * Common response builder
	 */
	private ResponseEntity<ErrorResponse> buildResponse(HttpStatus status, String message, String path) {

		ErrorResponse response = ErrorResponse.builder().timestamp(LocalDateTime.now()).status(status.value())
				.error(status.getReasonPhrase()).message(message).path(path).build();

		return ResponseEntity.status(status).body(response);
	}
}