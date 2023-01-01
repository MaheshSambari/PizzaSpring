package com.pizzaapplication.exception;

public class UserNotFoundException extends RuntimeException {

	public UserNotFoundException(int userId) {
	        super("Could not find User with User Id " + userId);
	
	}

	public UserNotFoundException() {
		
        super("User with this User Id  password is not correct");

		
	}
}

