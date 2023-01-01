package com.pizzaapplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pizzaapplication.entity.LineItem;

public interface LineItemRepository extends JpaRepository<LineItem,Integer> {

	public List<LineItem> findByCustomerId(int customerId);
	public void deleteByCustomerId(int customerId);
	public void deleteByPizzaId(int pizzaId);


}
