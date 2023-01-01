package com.pizzaapplication.exception;

import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class PizzaNotFoundAdvice {

	@ResponseBody
	@ExceptionHandler(PizzaNotFoundException.class)
	public ResponseEntity<ErrorMessage> handleEmployeeEXception(PizzaNotFoundException e) {
		ErrorMessage error = new ErrorMessage();
		error.setErrorCode(404);
		error.setErrorCodeDescription("Bad Request");
		error.setMessage(e.getMessage());
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorMessage> handleMethodArgumentInvalid(MethodArgumentNotValidException e){
		String errMsg=e.getAllErrors().stream().map(error->error.getDefaultMessage()).collect(Collectors.joining(","));
		ErrorMessage error = new ErrorMessage();
		error.setErrorCode(404);
		error.setErrorCodeDescription("Bad Request");
		error.setMessage(errMsg);
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}


}
