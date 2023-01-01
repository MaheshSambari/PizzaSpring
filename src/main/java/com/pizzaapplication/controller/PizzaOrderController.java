package com.pizzaapplication.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pizzaapplication.entity.PizzaOrder;
import com.pizzaapplication.entity.PlaceOrder;
import com.pizzaapplication.exception.CustomerNotFoundException;
import com.pizzaapplication.exception.CustomerOrderException;
import com.pizzaapplication.exception.PizzaNotFoundException;
import com.pizzaapplication.exception.PizzaOrderException;
import com.pizzaapplication.exception.PizzaOutOfStock;
import com.pizzaapplication.exception.SuccessMessage;
import com.pizzaapplication.service.PizzaOrderService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class PizzaOrderController {
	@Autowired
	private PizzaOrderService service;


	@GetMapping("/pizzaorder")
    public ResponseEntity<List<PizzaOrder>> getAllPizzaOrders()
    {
        List<PizzaOrder> list=service.getAllPizzaOrders();
        ResponseEntity<List<PizzaOrder>> response=new ResponseEntity<>(list,HttpStatus.OK);
        return response;
    }


	@GetMapping("/pizzaorderDate/{orderDate}")
	public ResponseEntity<List<PizzaOrder>> getByDate(@PathVariable("orderDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate orderDate ) throws PizzaOrderException
	{

		List<PizzaOrder> list=service.getPizzaOrderByDate(orderDate);
		ResponseEntity<List<PizzaOrder>> response=new ResponseEntity<>(list,HttpStatus.OK);
		return response;
	}


	@GetMapping("/pizzaorder/{orderid}")
	public ResponseEntity<List<PizzaOrder>> getById(@PathVariable("orderid") int orderId) throws PizzaOrderException 
	{
		List<PizzaOrder> tr=service.getPizzaOrderById(orderId);
		ResponseEntity<List<PizzaOrder>> response = new ResponseEntity<>(tr,HttpStatus.OK);
		return response;
	}


	 @DeleteMapping("/pizzaorder/{pizzaorderid}")
	    public ResponseEntity<SuccessMessage> deleteById(@PathVariable("pizzaorderid") int pizzaorderId) throws PizzaOrderException
	    {   
	        String tr=service.deletePizzaOrderById(pizzaorderId);
			SuccessMessage success = new SuccessMessage();
			success.setSuccessCode(200);
			success.setSuccessCodeDescription("Good Request");
			success.setSuccessMessage(tr);
	        ResponseEntity<SuccessMessage> response=new ResponseEntity<>(success,HttpStatus.OK);
	        return response;
	    }


	@PostMapping("/pizzaOrder")
	public ResponseEntity<SuccessMessage> orderPizza(@Valid @RequestBody PlaceOrder p) throws PizzaNotFoundException, CustomerNotFoundException,PizzaOutOfStock
	{
		String num=service.orderPizza(p);
		SuccessMessage success = new SuccessMessage();
		success.setSuccessCode(200);
		success.setSuccessCodeDescription("Good Request");
		success.setSuccessMessage(num);
		return new ResponseEntity<SuccessMessage>(success,HttpStatus.CREATED);
	}
	
	@GetMapping("/pizzaorderbycust/{customerId}")
	public ResponseEntity<List<PizzaOrder>> getByCustomerId(@PathVariable("customerId") int customerId) throws CustomerOrderException 
	{
		List<PizzaOrder> tr=service.getPizzaOrderByCustomerId(customerId);
		ResponseEntity<List<PizzaOrder>> response = new ResponseEntity<>(tr,HttpStatus.OK);
		return response;
	}

}
