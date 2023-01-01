package com.pizzaapplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.pizzaapplication.entity.Pizza;

public interface PizzaRepository extends JpaRepository<Pizza,Integer>{

	@Query("select p from Pizza p where pizzaType=?1") 
	public List<Pizza> getPizzaByType(String pizzaType);
	
	@Query("select p from Pizza p order by pizzacost asc")      
	public List<Pizza> getPizzaAsc();

	@Query("update Pizza p set p.pizzaCost=?2 where p.pizzaId=?1 ")      
	@Modifying
	void updatePizza(int pizzaId, double pizzaCost);
	
	@Query("select p from Pizza p order by pizzacost desc")      
	public List<Pizza> getPizzaDesc();
	

}
