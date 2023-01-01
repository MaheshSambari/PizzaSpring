package com.pizzaapplication.exception;

public class CustomerMobileFound extends Exception {

	public CustomerMobileFound(long mobile) {
	    super("We have already Account with "+ mobile );
	}

}
