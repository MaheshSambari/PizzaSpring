package com.pizzaapplication.exception;

public class CustomerNotFoundException extends Exception {

	public CustomerNotFoundException(int message) {
	    super("Could not find customer with Customer Id " + message);
	}
}
