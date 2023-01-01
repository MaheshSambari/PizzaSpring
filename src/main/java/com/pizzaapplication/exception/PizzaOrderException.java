package com.pizzaapplication.exception;

import java.time.LocalDate;
import java.util.Date;

public class PizzaOrderException  extends RuntimeException {

	public PizzaOrderException(int pizzaorderId) {
		super("Could not find pizza order with orderId " + pizzaorderId);
	}
	public PizzaOrderException(String pizzaType) {
		super("Could not find pizza order " + pizzaType);
	}
	public PizzaOrderException(LocalDate pizzaDate) {
		super("Could not find pizza orders on " + pizzaDate);
	}	
}
