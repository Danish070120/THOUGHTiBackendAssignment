package com.example.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.entity.Order;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(CustomException.class)
	public ResponseEntity<Order> orderNotfoundExceptionHandler(CustomException exception) {
		String message = exception.getMessage();
		Order order = new Order();
		return new ResponseEntity<Order>(order, HttpStatus.NOT_FOUND);

	}
}
