package com.pizzaapplication.service;

import java.util.List;


import com.pizzaapplication.entity.Customer;
import com.pizzaapplication.exception.CustomerNotFoundException;


public interface CustomerService {
	public String addCustomer(Customer c);
	public Customer updateCustomer(Customer c) throws CustomerNotFoundException;
    public String deleteCustomer(int customerId) throws CustomerNotFoundException;
    public List<Customer> viewCustomer();
    public Customer viewCustomer(int customerId) throws CustomerNotFoundException;
   
}
