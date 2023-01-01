package com.pizzaapplication.service;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import com.pizzaapplication.entity.PizzaOrder;
import com.pizzaapplication.exception.PizzaOrderException;

public interface PizzaOrderService {

	public List<PizzaOrder> getAllPizzaOrders();

	public List<PizzaOrder> getPizzaOrderByDate(LocalDate orderDate) throws PizzaOrderException;;

	public PizzaOrder getPizzaOrderById(int pizzaorderId) throws PizzaOrderException;

	public String deletePizzaOrderById(int pizzaorderId) throws PizzaOrderException;

	public String orderPizza(@Valid PizzaOrder p);

}
