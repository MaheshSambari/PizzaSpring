package com.pizzaapplication.exception;

public class PizzaNotFoundException extends RuntimeException {

	  public PizzaNotFoundException(int pizzaId) {
	    super("Could not find pizza  with pizza Id " + pizzaId);
	  }
	  public PizzaNotFoundException(String pizzaType) {
		    super("Could not find pizza with pizza Type " + pizzaType);
		  }
	  
}
