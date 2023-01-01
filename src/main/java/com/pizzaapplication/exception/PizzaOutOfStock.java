package com.pizzaapplication.exception;

public class PizzaOutOfStock extends RuntimeException {
	
	public PizzaOutOfStock() {
		
		super(" The Pizzas You are trying to Book is outof Stock ");
		
	}

}
