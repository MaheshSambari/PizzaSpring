package com.pizzaapplication.service;

import java.util.List;
import java.util.Optional;

import com.pizzaapplication.entity.LineItem;
import com.pizzaapplication.exception.CustomerNotFoundException;
import com.pizzaapplication.exception.ItemNotFoundException;
import com.pizzaapplication.exception.PizzaNotFoundException;

public interface LineItemService {

	public List<LineItem> getCart(int customerId) throws CustomerNotFoundException;

	public String deleteById(int sno) throws ItemNotFoundException;

	public String updateItem(LineItem item) throws ItemNotFoundException;

	public String addItem(LineItem l) throws CustomerNotFoundException, PizzaNotFoundException;

	public Optional<LineItem> getById(int sno) throws ItemNotFoundException;

}
