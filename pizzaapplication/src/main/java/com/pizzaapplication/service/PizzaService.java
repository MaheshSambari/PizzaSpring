package com.pizzaapplication.service;

import java.util.List;

import com.pizzaapplication.entity.Pizza;
import com.pizzaapplication.exception.PizzaNotFoundException;

public interface PizzaService {
	    public List<Pizza> getAllPizzas();
	    public List<Pizza> getPizzaByType(String pizzaType)throws PizzaNotFoundException;
	    public Pizza getPizzaById(int pizzaId) throws PizzaNotFoundException;
	    public String deletePizzaById(int pizzaId) throws PizzaNotFoundException;
	    public String updatePizza(int pizzaId, double pizzaCost) throws PizzaNotFoundException;
	    public List<Pizza> getPizzaAsc();
	    public String insertPizza(Pizza p);
		public List<Pizza> getPizzaDesc();
}
