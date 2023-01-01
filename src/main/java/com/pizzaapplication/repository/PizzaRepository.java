package com.pizzaapplication.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.pizzaapplication.entity.Pizza;

public interface PizzaRepository extends JpaRepository<Pizza,Integer>{

	//	@Query("select p from Pizza p where pizzaType=?1") 
	//	public List<Pizza> getPizzaByType(String pizzaType);

	public List<Pizza> findByPizzaType(String pizzaType);

	public List<Pizza> findByPizzaNameAndPizzaType(String pizzaName,String pizzaType);


	@Query("select p from Pizza p order by pizzacost asc")      
	public List<Pizza> getPizzaAsc();

	@Query("select p from Pizza p order by pizzacost desc")      
	public List<Pizza> getPizzaDesc();


}
