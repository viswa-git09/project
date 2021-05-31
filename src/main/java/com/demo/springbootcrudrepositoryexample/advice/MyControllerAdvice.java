package com.demo.springbootcrudrepositoryexample.advice;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.demo.springbootcrudrepositoryexample.exception.EmptyInputException;

import javassist.NotFoundException;

@RestControllerAdvice
public class MyControllerAdvice {
	
	@ExceptionHandler(EmptyInputException.class)
	
	public ResponseEntity<String> handleEmptyInput(EmptyInputException emptyInputException){
		
		return new ResponseEntity<String>("Input field is empty, please look into it", HttpStatus.BAD_REQUEST);
		
	}
	
	
	
}


