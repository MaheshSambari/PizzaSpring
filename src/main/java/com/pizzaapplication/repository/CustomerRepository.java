package com.pizzaapplication.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pizzaapplication.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	
	public Optional<Customer> findByCustomerMobile(long mobile);
	public Optional<Customer> findByCustomerEmailId(String mail);
	
    @Query("select p from Customer p where userModel.userId=?1") 
	public Optional<Customer> findByUserModel(int userId);

	
	

	

}
