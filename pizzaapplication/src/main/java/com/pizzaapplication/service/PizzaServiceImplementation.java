package com.pizzaapplication.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pizzaapplication.entity.Pizza;
import com.pizzaapplication.exception.PizzaNotFoundException;
import com.pizzaapplication.repository.PizzaRepository;

@Service
@Transactional
public class PizzaServiceImplementation implements PizzaService {
	
	 @Autowired
	    private PizzaRepository repository;
		String out ;

	 
	    @Override
	    public List<Pizza> getAllPizzas() {
	        return repository.findAll();
	    }
	    
	    @Override
	    public List<Pizza> getPizzaByType(String pizzaType) throws PizzaNotFoundException{
	    	List<Pizza> p = repository.getPizzaByType(pizzaType);

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
	          repository.deleteById(pizzaId);
	          return "Successfully Deleted";
	        }
	        else {throw new PizzaNotFoundException(pizzaId);}	

	    }
	   
	    @Override
	    public String insertPizza(Pizza p) {
	         repository.save(p);
	        return "Successfully Inserted and pizza Id is "+p.getPizzaId();
	    }
		
		@Override
		public String updatePizza(int pizzaId, double pizzaCost) throws PizzaNotFoundException {
			Optional<Pizza> pr=repository.findById(pizzaId);
	        if(pr.isPresent())
	               {
	                 repository.updatePizza(pizzaId,pizzaCost);
	                 out = "Successfully Updated";
	            	 return out;
	               }
	        else {throw new PizzaNotFoundException(pizzaId);}	

		}
//
		@Override
		public List<Pizza> getPizzaAsc() {
			return repository.getPizzaAsc();
		}

		@Override
		public List<Pizza> getPizzaDesc() {
			return repository.getPizzaDesc();

		}
		
}
