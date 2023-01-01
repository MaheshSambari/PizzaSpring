package com.pizzaapplication.exception;

public class CustomerOrderException extends RuntimeException {

	public CustomerOrderException(int cust) {
		super("Could not find orders with customer Id " + cust);
	}
}