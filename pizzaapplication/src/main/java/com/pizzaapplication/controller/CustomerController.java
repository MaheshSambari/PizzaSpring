package com.pizzaapplication.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pizzaapplication.entity.Customer;
import com.pizzaapplication.exception.CustomerNotFoundException;
import com.pizzaapplication.exception.SuccessMessage;
import com.pizzaapplication.service.CustomerService;

@RestController
public class CustomerController {
	
@Autowired
public CustomerService service;
	
	@PostMapping("/customers")
	public ResponseEntity<SuccessMessage> addCustomer(@Valid @RequestBody Customer c)
	{
		 String tr = service.addCustomer(c);
		 SuccessMessage success = new SuccessMessage();
	        success.setSuccessCode(200);
	        success.setSuccessCodeDescription("Good Request");
	        success.setSuccessMessage(tr);
	        return new ResponseEntity<>(success,HttpStatus.OK);
		 
	}
	@GetMapping("/customers")
	public ResponseEntity<List<Customer>> viewCustomer(){
		List<Customer> list= service.viewCustomer();
		ResponseEntity<List<Customer>> response = new ResponseEntity<>(list, HttpStatus.OK);
		return response;
	}
	@PutMapping("/customers")
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer c) throws CustomerNotFoundException{
		Customer customer= service.updateCustomer(c);
		ResponseEntity<Customer> response = new ResponseEntity<>(customer, HttpStatus.OK);
		return response;
	}
	@DeleteMapping("/customers/{cid}")
	public  ResponseEntity<SuccessMessage> deleteCustomer(@PathVariable("cid")Integer id) throws CustomerNotFoundException {
		String tr = service.deleteCustomer(id);
		SuccessMessage success = new SuccessMessage();
	    success.setSuccessCode(200);
	    success.setSuccessCodeDescription("Good Request");
        success.setSuccessMessage(tr);
	    return new ResponseEntity<>(success,HttpStatus.OK);  
	}
	
	@GetMapping("/customers/{cid}")
	public  ResponseEntity<Customer> getCustomer(@PathVariable("cid")Integer id) throws CustomerNotFoundException {
		Customer list = service.viewCustomer(id);
		ResponseEntity<Customer> response = new ResponseEntity<>(list, HttpStatus.OK);
	    return response;  
	}

}
