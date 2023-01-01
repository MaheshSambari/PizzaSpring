package com.pizzaapplication.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pizzaapplication.exception.SuccessMessage;
import com.pizzaapplication.service.UserLoginService;

@RestController
@Validated
public class UserLoginController {
    @Autowired
    private UserLoginService service;
    
    @RequestMapping(value="/userlogin", method=RequestMethod.GET)
    @Valid
    @ResponseBody
    public ResponseEntity<SuccessMessage> userLogin(int userId, String userPassword)
    {
        String tr=service.userLogin(userId, userPassword);
        SuccessMessage success = new SuccessMessage();
        success.setSuccessCode(200);
        success.setSuccessCodeDescription("Good Request");
        success.setSuccessMessage(tr);
        return new ResponseEntity<>(success,HttpStatus.OK);
    }
    
    @RequestMapping(value="/userpasswordreset", method=RequestMethod.PUT) 
    @ResponseBody
    public ResponseEntity<SuccessMessage> updateUserPass(int userId, String userPassword)
    {
        String tr=service.updateUserPass(userId, userPassword);
        SuccessMessage success = new SuccessMessage();
        success.setSuccessCode(200);
        success.setSuccessCodeDescription("Good Request");
        success.setSuccessMessage(tr);
        return new ResponseEntity<>(success,HttpStatus.OK);
        
    }
    
}


