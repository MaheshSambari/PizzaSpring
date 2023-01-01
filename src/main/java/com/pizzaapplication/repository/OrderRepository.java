package com.pizzaapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.pizzaapplication.entity.Order;

public interface OrderRepository extends JpaRepository<Order,Integer> {

	
	@Modifying
	@Query("update Order o set ordercustomerid=null where ordercustomerid=?1")
	public void deleteByorderCustomerId(int orderCustomerId);
	
}
