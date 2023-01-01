package com.pizzaapplication.exception;

public class ItemNotFoundException extends Exception {

	public ItemNotFoundException(){
		super("there is no item");
	}


}
