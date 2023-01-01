package com.pizzaapplication.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pizzaapplication.entity.Pizza;
import com.pizzaapplication.exception.PizzaNameExcistException;
import com.pizzaapplication.exception.PizzaNotFoundException;
import com.pizzaapplication.repository.LineItemRepository;
import com.pizzaapplication.repository.PizzaOrderRepository;
import com.pizzaapplication.repository.PizzaRepository;

@Service
@Transactional
public class PizzaServiceImplementation implements PizzaService {
    
	@Autowired
	private PizzaRepository repository;
	@Autowired
	private LineItemRepository lRepository;
	@Autowired
	private PizzaOrderRepository poRepository;
	String out ;


	@Override
	public List<Pizza> getAllPizzas() {
		return repository.findAll();
	}


	@Override
	public List<Pizza> getPizzaByType(String pizzaType) throws PizzaNotFoundException{
		List<Pizza> p = repository.findByPizzaType(pizzaType);
		if(p.size()!=0) {
			return p;
		}
		else {throw new PizzaNotFoundException(pizzaType);}	
	}


	@Override
	public Pizza getPizzaById(int pizzaId) throws PizzaNotFoundException {
		Optional<Pizza> p=repository.findById(pizzaId);
		if(p.isPresent()) {
			return p.get();
		}
		else {throw new PizzaNotFoundException(pizzaId);}	
	}


	@Override
	public String deletePizzaById(int pizzaId) throws PizzaNotFoundException {
		Optional<Pizza> p=repository.findById(pizzaId);
		if(p.isPresent()) {
			lRepository.deleteByPizzaId(pizzaId);
			poRepository.updateById(pizzaId);
			repository.deleteById(pizzaId);
			return "Successfully Deleted";
		}
		else {throw new PizzaNotFoundException(pizzaId);}	
	}


	@Override
	public String insertPizza(Pizza p) throws PizzaNameExcistException {

		List<Pizza> p1=repository.findByPizzaNameAndPizzaType(p.getPizzaName(),p.getPizzaType());
		if(p1.size()==0) {
			repository.save(p);
			return "Successfully Inserted and pizza Id is "+p.getPizzaId();
		}

		else {throw new PizzaNameExcistException();}	
	}



	@Override
	public String updatePizza(Pizza pizza) throws PizzaNotFoundException {
		Optional<Pizza> pr=repository.findById(pizza.getPizzaId());
		Pizza pizza1=null;
		if(pr.isPresent())
		{
			pizza1=pr.get();
			pizza1.setPizzaCost(pizza.getPizzaCost());
			pizza1.setPizzaDescription(pizza.getPizzaDescription());
			pizza1.setPizzaName(pizza.getPizzaName());
			pizza1.setPizzaType(pizza.getPizzaType());
			pizza1.setAvailableQuantity(pizza.getAvailableQuantity());
			out = "Successfully Updated";
			return out;
		}
		else {throw new PizzaNotFoundException(pizza.getPizzaId());}	
	}


	@Override
	public List<Pizza> getPizzaAsc() {
		return repository.getPizzaAsc();
	}


	@Override
	public List<Pizza> getPizzaDesc() {
		return repository.getPizzaDesc();
	}


}
