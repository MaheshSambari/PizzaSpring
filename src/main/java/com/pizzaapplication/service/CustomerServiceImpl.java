package com.pizzaapplication.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pizzaapplication.entity.Customer;
import com.pizzaapplication.exception.CustomerMobileFound;
import com.pizzaapplication.exception.CustomerNotFoundException;
import com.pizzaapplication.repository.CustomerRepository;
import com.pizzaapplication.repository.LineItemRepository;
import com.pizzaapplication.repository.OrderRepository;

@Service
@Transactional
public class CustomerServiceImpl  implements CustomerService {
	
	@Autowired
	private CustomerRepository repository;
	@Autowired
	private LineItemRepository lRepository;
	@Autowired
	private OrderRepository oRepository;
	
	
	@Override
	public String addCustomer(Customer c) throws CustomerNotFoundException, CustomerMobileFound {
		Optional<Customer> customer=repository.findByCustomerMobile(c.getCustomerMobile());
		if(!customer.isPresent()) {
			Optional<Customer> cust=repository.findByCustomerEmailId(c.getCustomerEmailId());
			if(!cust.isPresent()) {
				repository.save(c);
				return "Customer created Succesfully and Custemer Id is "+c.getCustomerId() +" User id is " + c.getUserModel().getUserId(); 
			}	 
			else { throw new CustomerNotFoundException(c.getCustomerEmailId());}
		}
		else { throw new CustomerMobileFound(c.getCustomerMobile());}
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
			lRepository.deleteByCustomerId(customerId);
			oRepository.deleteByorderCustomerId(customerId);
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
