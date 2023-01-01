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

import com.pizzaapplication.entity.Pizza;
import com.pizzaapplication.service.PizzaService;
import com.pizzaapplication.exception.ErrorMessage;
import com.pizzaapplication.exception.PizzaNotFoundException;
import com.pizzaapplication.exception.SuccessMessage;
@RestController
public class PizzaController {
	@Autowired
    private PizzaService service;
    @GetMapping("/pizza")
    public ResponseEntity<List<Pizza>> getAllPizza()
    {
        List<Pizza> list=service.getAllPizzas();
        ResponseEntity<List<Pizza>> response=new ResponseEntity<>(list,HttpStatus.OK);
        return response;
    }
    @GetMapping("/pizzatype/{name}")
    public ResponseEntity<List<Pizza>> getByname(@PathVariable("name") String pizzaType) throws PizzaNotFoundException
    {
        List<Pizza> list=service.getPizzaByType(pizzaType);
        ResponseEntity<List<Pizza>> response=new ResponseEntity<>(list,HttpStatus.OK);
        return response;
    }
    @GetMapping("/pizza/{id}")
    public ResponseEntity<Pizza> getById(@PathVariable("id") int pizzaId) throws PizzaNotFoundException 
    {
        Pizza tr=service.getPizzaById(pizzaId);
        ResponseEntity<Pizza> response=new ResponseEntity<>(tr,HttpStatus.FOUND);
        return response;
    }
    @DeleteMapping("/pizza/{id}")
    public ResponseEntity<SuccessMessage> deleteById(@PathVariable("id") int pizzaId) throws PizzaNotFoundException
    {   
        String tr=service.deletePizzaById(pizzaId);
        SuccessMessage success = new SuccessMessage();
        success.setSuccessCode(200);
        success.setSuccessCodeDescription("Good Request");
        success.setSuccessMessage(tr);
        return new ResponseEntity<>(success,HttpStatus.OK);
       
    }
    @PutMapping("/pizza/{id}/{cost}")
    public ResponseEntity<SuccessMessage> updatePizza(@PathVariable("id") int pizzaId,@PathVariable("cost") double pizzaCost) throws PizzaNotFoundException
    {
        String tr=service.updatePizza(pizzaId,pizzaCost);
        SuccessMessage success = new SuccessMessage();
        success.setSuccessCode(200);
        success.setSuccessCodeDescription("Good Request");
        success.setSuccessMessage(tr);
        return new ResponseEntity<>(success,HttpStatus.OK);
    }
    @PostMapping("/pizza")
    public ResponseEntity<SuccessMessage> savePizza(@Valid @RequestBody Pizza p)
    {
        String num=service.insertPizza(p);
        SuccessMessage success = new SuccessMessage();
        success.setSuccessCode(200);
        success.setSuccessCodeDescription("Good Request");
        success.setSuccessMessage(num);
        return new ResponseEntity<>(success,HttpStatus.OK);
    }
    @GetMapping("/pizzaAsc")
    public ResponseEntity<List<Pizza>> getPizzaAsc()
    {
        List<Pizza> list=service.getPizzaAsc();
        ResponseEntity<List<Pizza>> response=new ResponseEntity<>(list,HttpStatus.OK);
        return response;
    }
    @GetMapping("/pizzaDesc")
    public ResponseEntity<List<Pizza>> getPizzaDesc()
    {
        List<Pizza> list=service.getPizzaDesc();
        ResponseEntity<List<Pizza>> response=new ResponseEntity<>(list,HttpStatus.OK);
        return response;
    }
}
