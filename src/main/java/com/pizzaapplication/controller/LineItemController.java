package com.pizzaapplication.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pizzaapplication.entity.LineItem;
import com.pizzaapplication.entity.Pizza;
import com.pizzaapplication.exception.CustomerNotFoundException;
import com.pizzaapplication.exception.ItemNotFoundException;
import com.pizzaapplication.exception.PizzaNotFoundException;
import com.pizzaapplication.exception.SuccessMessage;
import com.pizzaapplication.service.LineItemService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class LineItemController {

	@Autowired
	private LineItemService service;


	@GetMapping("/getcartbycustomer/{id}")
	public ResponseEntity<List<LineItem>> getCart(@PathVariable("id") int customerId) throws CustomerNotFoundException 
	{
		List<LineItem> tr = service.getCart(customerId);
		ResponseEntity<List<LineItem>> response = new ResponseEntity<>(tr,HttpStatus.OK);
		return response;
	}


	@GetMapping("/getcartbysno/{id}")
	public ResponseEntity<Optional<LineItem>> getCart1(@PathVariable("id") int customerId) throws ItemNotFoundException 
	{
		Optional<LineItem> tr = service.getById(customerId);
		ResponseEntity<Optional<LineItem>> response = new ResponseEntity<>(tr,HttpStatus.OK);
		return response;
	}


	@DeleteMapping("/deletecartbysno/{id}")
	public ResponseEntity<SuccessMessage> deleteById(@PathVariable("id") int sno) throws ItemNotFoundException{   
		String tr=service.deleteById(sno);
		SuccessMessage success = new SuccessMessage();
		success.setSuccessCode(200);
		success.setSuccessCodeDescription("Good Request");
		success.setSuccessMessage(tr);
		return new ResponseEntity<SuccessMessage>(success,HttpStatus.OK);
	}


	@PutMapping("/updatecartbysno")
	public ResponseEntity<SuccessMessage> updatePizza(@Valid @RequestBody LineItem p) throws ItemNotFoundException{
		String tr=service.updateItem(p);
		SuccessMessage success = new SuccessMessage();
		success.setSuccessCode(200);
		success.setSuccessCodeDescription("Good Request");
		success.setSuccessMessage(tr);
		return new ResponseEntity<SuccessMessage>(success,HttpStatus.OK);
	}


	@PostMapping("/addtocart")
	public ResponseEntity<SuccessMessage> addItem(@Valid @RequestBody LineItem l) throws PizzaNotFoundException, CustomerNotFoundException
	{
		String num=service.addItem(l);
		SuccessMessage success = new SuccessMessage();
		success.setSuccessCode(200);
		success.setSuccessCodeDescription("Good Request");
		success.setSuccessMessage(num);
		return new ResponseEntity<SuccessMessage>(success,HttpStatus.OK);
	}


}