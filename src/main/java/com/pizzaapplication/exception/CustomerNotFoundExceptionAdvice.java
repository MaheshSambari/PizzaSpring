package com.pizzaapplication.exception;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomerNotFoundExceptionAdvice {
	
	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<ErrorMessage> handleCustomerException(CustomerNotFoundException t)
	{
	
		ErrorMessage error=new ErrorMessage();
		error.setErrorCode(404);
		error.setErrorCodeDescription("Bad request");
		error.setMessage(t.getMessage());
		return new ResponseEntity<>(error,HttpStatus.OK);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	  public ResponseEntity<ErrorMessage> handleMethodArgumentInvalid(MethodArgumentNotValidException e){
	  String errMsg=e.getAllErrors().stream().map(error->error.getDefaultMessage()).collect(Collectors.joining(","));
	  ErrorMessage error = new ErrorMessage();
	  error.setErrorCode(404);
	  error.setErrorCodeDescription("Bad Request");
	  error.setMessage(errMsg);
	  return new ResponseEntity<>(error,HttpStatus.OK);
	  }
	
	
	
}