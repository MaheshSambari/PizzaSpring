package com.pizzaapplication.exception;

public class PizzaNameExcistException extends RuntimeException{

	public PizzaNameExcistException(){
		super("Already Pizza With This Name and Type Combination is Availabe");
	}

}
