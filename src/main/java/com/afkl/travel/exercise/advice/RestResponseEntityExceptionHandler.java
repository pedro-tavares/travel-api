package com.afkl.travel.exercise.advice;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import javax.persistence.NoResultException;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = { IllegalArgumentException.class, IllegalStateException.class })
	protected ResponseEntity<Object> handleException(RuntimeException ex, WebRequest request) {
		String bodyOfResponse = "An Error Occurred";
		return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.CONFLICT, request);
	}

	@ExceptionHandler(value = { NoResultException.class })
	protected ResponseEntity<Object> handleNoLocationFound(RuntimeException ex, WebRequest request) {
		String bodyOfResponse = "Location not Found.";
		return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.CONFLICT, request);
	}

}
