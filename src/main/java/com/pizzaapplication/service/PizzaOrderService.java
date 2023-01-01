package com.pizzaapplication.service;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import com.pizzaapplication.entity.LineItem;
import com.pizzaapplication.entity.Order;
import com.pizzaapplication.entity.PizzaOrder;
import com.pizzaapplication.entity.PlaceOrder;
import com.pizzaapplication.exception.CustomerNotFoundException;
import com.pizzaapplication.exception.CustomerOrderException;
import com.pizzaapplication.exception.PizzaNotFoundException;
import com.pizzaapplication.exception.PizzaOrderException;
import com.pizzaapplication.exception.PizzaOutOfStock;

public interface PizzaOrderService {

	public List<PizzaOrder> getAllPizzaOrders();

	public List<PizzaOrder> getPizzaOrderByDate(LocalDate orderDate) throws PizzaOrderException;;

	public List<PizzaOrder> getPizzaOrderById(int orderId) throws PizzaOrderException;

	public String deletePizzaOrderById(int pizzaorderId) throws PizzaOrderException;

	public String orderPizza(PlaceOrder p) throws CustomerNotFoundException,PizzaNotFoundException,PizzaOutOfStock;

	public List<PizzaOrder> getPizzaOrderByCustomerId(int customerId) throws CustomerOrderException;
	

}
