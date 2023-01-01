package com.pizzaapplication.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pizzaapplication.entity.PizzaOrder;
import com.pizzaapplication.exception.PizzaOrderException;
import com.pizzaapplication.repository.PizzaOrderRepository;

@Service
@Transactional
public class PizzaOrderServiceImpl implements PizzaOrderService {
  @Autowired
  private PizzaOrderRepository repository;

	@Override
	public List<PizzaOrder> getAllPizzaOrders() {
		return repository.findAll();
	}

	@Override
	public List<PizzaOrder> getPizzaOrderByDate(LocalDate orderDate) throws PizzaOrderException {
		List<PizzaOrder> p = repository.findByDate(orderDate);
		if(p.size()!=0) {
			return p;
		}
		else {throw new PizzaOrderException(orderDate);}
		}

	@Override
	public PizzaOrder getPizzaOrderById(int pizzaorderId) throws PizzaOrderException {
		Optional<PizzaOrder> p = repository.findById(pizzaorderId);
		PizzaOrder po = null;
		if(p.isPresent()) {
			po=p.get();
			return po;
		}
		else {throw new PizzaOrderException(pizzaorderId);}
	}

	@Override
	public String deletePizzaOrderById(int pizzaorderId) throws PizzaOrderException{
		
		Optional<PizzaOrder> p = repository.findById(pizzaorderId);
		if(p.isPresent()) {
			repository.deleteById(pizzaorderId);
			return "you are Succesfully canceled your Order";
		}
		else {throw new PizzaOrderException(pizzaorderId);}	}

	@Override
	public String orderPizza(@Valid PizzaOrder p) {
		repository.save(p);
		return "Your Order Succesfully Placed";
	}

}
