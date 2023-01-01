package com.pizzaapplication.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pizzaapplication.entity.Customer;
import com.pizzaapplication.entity.LineItem;
import com.pizzaapplication.entity.Pizza;
import com.pizzaapplication.exception.CustomerNotFoundException;
import com.pizzaapplication.exception.ItemNotFoundException;
import com.pizzaapplication.exception.PizzaNotFoundException;
import com.pizzaapplication.repository.CustomerRepository;
import com.pizzaapplication.repository.LineItemRepository;
import com.pizzaapplication.repository.PizzaRepository;

@Service
@Transactional
public class LineItemServiceImplementation implements LineItemService{
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private PizzaRepository pizzaRepository;
	@Autowired 
	private LineItemRepository cartRepository;
	String out=null;


	@Override
	public List<LineItem> getCart(int customerId) throws CustomerNotFoundException {
		Optional<Customer> cust = customerRepository.findById(customerId);
		if(cust.isPresent()) {
			List<LineItem> cust1 = cartRepository.findByCustomerId(customerId);
			if(cust1.size()!=0) {		
				return cartRepository.findByCustomerId(customerId);
			}
			else { throw new CustomerNotFoundException();}
		}
		else { throw new CustomerNotFoundException(customerId);}

	}



	@Override
	public String deleteById(int sno) throws ItemNotFoundException {
		Optional<LineItem> p=cartRepository.findById(sno);
		if(p.isPresent()) {
			cartRepository.deleteById(sno);
			return "Successfully Deleted";
		}
		else {throw new ItemNotFoundException();}	
	}



	@Override
	public Optional<LineItem> getById(int sno) throws ItemNotFoundException {
		Optional<LineItem> p=cartRepository.findById(sno);
		if(p.isPresent()) {
			return p;
		}
		else {throw new ItemNotFoundException();}	
	}



	@Override
	public String updateItem(LineItem item) throws ItemNotFoundException {
		Optional<LineItem> pr=cartRepository.findById(item.getSno());
		LineItem item1=null;
		if(pr.isPresent())
		{
			item1=pr.get();
			item1.setSize(item.getSize());
			item1.setQuantity(item.getQuantity());
			item1.setSize(item.getSize());
			double pizzaCost=0.0;
			Optional<Pizza> p1 = pizzaRepository.findById(item1.getPizzaId()); 
			Pizza p2 = p1.get();
			if(item1.getSize().equals("medium")) {
				pizzaCost = p2.getPizzaCost()*1.2;
			}
			if(item1.getSize().equals("large")) {
				pizzaCost = p2.getPizzaCost()*1.5;
			}
			if(item1.getSize().equals("small")) {
				pizzaCost = p2.getPizzaCost();
			}

			item1.setTotalAmount(item1.getQuantity()*pizzaCost);
			out = "Successfully Updated";
			return out;
		}
		else {throw new PizzaNotFoundException(item.getSno());}	
	}



	@Override
	public String addItem(LineItem l) throws CustomerNotFoundException, PizzaNotFoundException {

		Optional<Customer> cust = customerRepository.findById(l.getCustomerId());
		if(cust.isPresent()) {
			Optional<Pizza> p1 = pizzaRepository.findById(l.getPizzaId()); 
			if(p1.isPresent()) {
				double pizzaCost=0.0;
				Pizza p2 = p1.get();
				if(l.getSize().equals("medium")) {
					pizzaCost = p2.getPizzaCost()*1.2;
				}
				if(l.getSize().equals("large")) {
					pizzaCost = p2.getPizzaCost()*1.5;
				}
				if(l.getSize().equals("small")) {
					pizzaCost = p2.getPizzaCost();
				}

				l.setTotalAmount(l.getQuantity()*pizzaCost);
				cartRepository.save(l);
				return "Added to cart Successful";
			}
			else {throw new PizzaNotFoundException(l.getPizzaId());}}	
		else { throw new CustomerNotFoundException(l.getCustomerId());}

	}

}
