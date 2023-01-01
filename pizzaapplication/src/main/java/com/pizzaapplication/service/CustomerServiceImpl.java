package com.pizzaapplication.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pizzaapplication.entity.Customer;
import com.pizzaapplication.exception.CustomerNotFoundException;
import com.pizzaapplication.repository.CustomerRepository;

@Service
@Transactional
public class CustomerServiceImpl  implements CustomerService {
	
	@Autowired
	private CustomerRepository repository;

	@Override
	public String addCustomer(Customer c) {
		// TODO Auto-generated method stub
		 repository.save(c);
		 return "Customer created Succesfully and Custemer Id is "+c.getCustomerId() +" User id is " + c.getUser().getUserId(); 
	}

	@Override
	public Customer updateCustomer(Customer c) throws CustomerNotFoundException {
		Optional<Customer> option = repository.findById(c.getCustomerId());
		Customer customer= null;
		
		if(option.isPresent()) {
			customer=option.get();
			customer.setCustomerName(c.getCustomerName());
			customer.setCustomerMobile(c.getCustomerMobile());
			customer.setCustomerEmailId(c.getCustomerEmailId());
			customer.setCustomerAddress(c.getCustomerAddress());
		    return customer;}
  		else { throw new CustomerNotFoundException(c.getCustomerId());}
	}

	@Override
	public String deleteCustomer(int customerId) throws CustomerNotFoundException {
		Optional<Customer> option = repository.findById(customerId);
		if(option.isPresent()) {		
			repository.deleteById(customerId);
      		return "Deleted Sucesfully";}
      		else { throw new CustomerNotFoundException(customerId);}
      	
	}

	@Override
	public List<Customer> viewCustomer() {
		return repository.findAll();		
	}

	@Override
	public Customer viewCustomer(int customerId) throws CustomerNotFoundException {
		Optional<Customer> option =  repository.findById(customerId);
		if(!option.isPresent())
		{
			throw new CustomerNotFoundException(customerId);
		}
		else
			return option.get();
		}
}
