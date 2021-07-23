package com.abhi.enterprizeprojects.SpringBootMicroservicesForBreweries.breweries.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BreweryV1ExceptionHandler {
	
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<List> validationsErrorHandler(ConstraintViolationException e) {
		
		List<String> errors = new ArrayList<>(e.getConstraintViolations().size());
		
		e.getConstraintViolations().forEach(constraintViolation -> {
			errors.add(constraintViolation.getPropertyPath() + ":" + constraintViolation.getMessage());
		});
		
		return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(BindException.class)
	public ResponseEntity<List> handleBindException(BindException be) {
		
		return new ResponseEntity<List>(be.getAllErrors(), HttpStatus.BAD_REQUEST);
	}

}
