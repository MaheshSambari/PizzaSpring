package com.pizzaapplication.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pizzaapplication.entity.PizzaOrder;

public interface PizzaOrderRepository extends JpaRepository<PizzaOrder,Integer>{

	@Query("select p from PizzaOrder p where orderdate=?1")
	List<PizzaOrder> findByDate(LocalDate orderDate);

}
