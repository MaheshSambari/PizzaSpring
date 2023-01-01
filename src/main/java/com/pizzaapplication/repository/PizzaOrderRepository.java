package com.pizzaapplication.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.pizzaapplication.entity.PizzaOrder;

public interface PizzaOrderRepository extends JpaRepository<PizzaOrder,Integer>{

	@Query("select p from PizzaOrder p where orderdate=?1")
	List<PizzaOrder> findByDate(LocalDate orderDate);
	
	@Query("select p from PizzaOrder p where p.order.orderId=?1")
	List<PizzaOrder> findById1(int orderId);
	
	@Modifying
	@Query("delete from PizzaOrder p where pizzaorderId=?1")
	public void deleteById1(int orderId);
	
	@Modifying
	@Query("update PizzaOrder p set p.pizza.pizzaId=null where p.pizza.pizzaId=?1")
	public void updateById(int pizzaId);

	
	@Query("select p from PizzaOrder p where p.order.orderCustomerId.customerId=?1")
	public List<PizzaOrder> findByCustomerId1(int customerId);
	
	
	

}
