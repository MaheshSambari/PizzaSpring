package com.pizzaapplication.controller;

import java.util.List;

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

import com.pizzaapplication.entity.Pizza;
import com.pizzaapplication.service.PizzaService;
import com.pizzaapplication.exception.PizzaNameExcistException;
import com.pizzaapplication.exception.PizzaNotFoundException;
import com.pizzaapplication.exception.SuccessMessage;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class PizzaController {
	@Autowired
	private PizzaService service;


	// RESTful API methods for Retrieval operation
	@GetMapping("/getpizza")
	public ResponseEntity<List<Pizza>> getAllPizza(){
		List<Pizza> list=service.getAllPizzas();
		ResponseEntity<List<Pizza>> response=new ResponseEntity<>(list,HttpStatus.OK);
		return response;
	}


	// RESTful API methods for Retrieval operation by Pizza Type
	@GetMapping("/getpizzabytype/{name}")
	public ResponseEntity<List<Pizza>> getByname(@PathVariable("name") String pizzaType) throws PizzaNotFoundException{
		List<Pizza> list=service.getPizzaByType(pizzaType);
		ResponseEntity<List<Pizza>> response=new ResponseEntity<>(list,HttpStatus.OK);
		return response;
	}


	// RESTful API methods for Retrieval operation by Pizza Id
	@GetMapping("/getpizzabyid/{id}")
	public ResponseEntity<Pizza> getById(@PathVariable("id") int pizzaId) throws PizzaNotFoundException {
		Pizza tr=service.getPizzaById(pizzaId);
		ResponseEntity<Pizza> response=new ResponseEntity<>(tr,HttpStatus.OK);
		return response;
	}


	// RESTful API methods for Delete operation
	@DeleteMapping("/deletepizza/{id}")
	public ResponseEntity<SuccessMessage> deleteById(@PathVariable("id") int pizzaId) throws PizzaNotFoundException{   
		String tr=service.deletePizzaById(pizzaId);
		SuccessMessage success = new SuccessMessage();
		success.setSuccessCode(200);
		success.setSuccessCodeDescription("Good Request");
		success.setSuccessMessage(tr);
		return new ResponseEntity<SuccessMessage>(success,HttpStatus.OK);
	}


	// RESTful API methods for Update operation
	@PutMapping("/updatepizza")
	public ResponseEntity<SuccessMessage> updatePizza(@Valid @RequestBody Pizza p) throws PizzaNotFoundException{
		String tr=service.updatePizza(p);
		SuccessMessage success = new SuccessMessage();
		success.setSuccessCode(200);
		success.setSuccessCodeDescription("Good Request");
		success.setSuccessMessage(tr);
		return new ResponseEntity<SuccessMessage>(success,HttpStatus.OK);
	}


	// RESTful API methods for Create operation 
	@PostMapping("/savepizza")
	public ResponseEntity<SuccessMessage> savePizza(@Valid @RequestBody Pizza p) throws PizzaNameExcistException{
		String num=service.insertPizza(p);
		SuccessMessage success = new SuccessMessage();
		success.setSuccessCode(200);
		success.setSuccessCodeDescription("Good Request");
		success.setSuccessMessage(num);
		return new ResponseEntity<>(success,HttpStatus.OK);
	}


	// RESTful API methods for Retrieval operation in ascending order
	@GetMapping("/getpizzaAsc")
	public ResponseEntity<List<Pizza>> getPizzaAsc(){
		List<Pizza> list=service.getPizzaAsc();
		ResponseEntity<List<Pizza>> response=new ResponseEntity<>(list,HttpStatus.OK);
		return response;
	}


	// RESTful API methods for Retrieval operation in descending order
	@GetMapping("/getpizzaDesc")
	public ResponseEntity<List<Pizza>> getPizzaDesc(){
		List<Pizza> list=service.getPizzaDesc();
		ResponseEntity<List<Pizza>> response=new ResponseEntity<>(list,HttpStatus.OK);
		return response;
	}


}