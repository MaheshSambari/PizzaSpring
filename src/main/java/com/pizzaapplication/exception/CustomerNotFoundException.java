package com.pizzaapplication.exception;

public class CustomerNotFoundException extends Exception {

	public CustomerNotFoundException(int id) {
	    super("Could not find customer with Customer Id " + id);
	}
	public CustomerNotFoundException(String mail) {
	    super("We have already Account with "+ mail);
	}
	public CustomerNotFoundException() {
	    super("You Don't Have Any Items In Your Cart");
	}
}
