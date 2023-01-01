package com.pizzaapplication.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pizzaapplication.entity.Pizza;
import com.pizzaapplication.entity.UserLogin;
import com.pizzaapplication.exception.SuccessMessage;
import com.pizzaapplication.service.UserLoginService;

@CrossOrigin(origins="*")
@RestController
public class UserLoginController {
    @Autowired
    private UserLoginService service;
    
    // RESTful API methods for Retrieval operation
    @PostMapping("/userlogin")
	public ResponseEntity<Integer> authenticateUser(@RequestBody UserLogin u){
		Integer customerId=service.userLogin(u.getUserId(), u.getUserPassword());
		ResponseEntity<Integer> response=new ResponseEntity<Integer>(customerId,HttpStatus.OK);
		return response;
	}

    
    // RESTful API methods for Update operation
    @RequestMapping(value="/userpasswordreset", method=RequestMethod.PUT) 
    public ResponseEntity<SuccessMessage> updateUserPass(@RequestBody UserLogin user)
    {
        String tr=service.updateUserPass(user.getUserId(), user.getUserPassword());
        SuccessMessage success = new SuccessMessage();
        success.setSuccessCode(200);
        success.setSuccessCodeDescription("Good Request");
        success.setSuccessMessage(tr);
        return new ResponseEntity<>(success,HttpStatus.OK);        
    }
        
    
}


