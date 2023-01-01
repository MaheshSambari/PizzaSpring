package com.pizzaapplication.controller;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pizzaapplication.entity.Pizza;
import com.pizzaapplication.entity.PizzaOrder;
import com.pizzaapplication.exception.PizzaOrderException;
import com.pizzaapplication.service.PizzaOrderService;

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
    @GetMapping("/pizzaorder/{pizzaorderid}")
    public ResponseEntity<PizzaOrder> getById(@PathVariable("pizzaorderid") int pizzaorderId) throws PizzaOrderException 
    {
        PizzaOrder tr=service.getPizzaOrderById(pizzaorderId);
        ResponseEntity<PizzaOrder> response = new ResponseEntity<>(tr,HttpStatus.FOUND);
        return response;
    }
    @DeleteMapping("/pizzaorder/{pizzaorderid}")
    public ResponseEntity<String> deleteById(@PathVariable("pizzaorderid") int pizzaorderId) throws PizzaOrderException
    {   
        String tr=service.deletePizzaOrderById(pizzaorderId);
        ResponseEntity<String> response=new ResponseEntity<>(tr,HttpStatus.OK);
        return response;
    }
//    @PutMapping("/pizzaorder/{pizzaorderid}/{totalcost}")
//    public ResponseEntity<String> updatePizza(@PathVariable("pizzaorderid") int pizzaorderId,@PathVariable("totalcost") double totalCost) throws PizzaOrderException
//    {
//        String tr=service.updatePizzaOrder(pizzaorderId);
//        ResponseEntity<String> response=new ResponseEntity<>(tr,HttpStatus.OK);
//        return response;
//        
//    }
//    
    @PostMapping("/pizzaOrder")
    public ResponseEntity<String> orderPizza(@Valid @RequestBody PizzaOrder p)
    {
        String num=service.orderPizza(p);
        ResponseEntity<String> response=new ResponseEntity<>(num,HttpStatus.CREATED);
        return response;
    }
//    
//    @PostMapping("/quantity")
//    public ResponseEntity<String> savePizza(@Valid @RequestBody PizzaOrder p)
//    {
//        String num=service.insertQuantity(p);
//        ResponseEntity<String> response=new ResponseEntity<>(num,HttpStatus.CREATED);
//        return response;
//    }
//    
//    @GetMapping("/totalCost/{size}/{quantity}")
//    public ResponseEntity<List<PizzaOrder>> getTotalCost(@PathVariable("pizzaSize") String size, @PathVariable("pizzaQuantity"), int quantity) throws PizzaOrderException
//    {
//        PizzaOrder tr=service.getTotalCost(totalCost);
//        ResponseEntity<List<PizzaOrder>> response=new ResponseEntity<>(tr,HttpStatus.OK);
//        return response;
//        }
}
