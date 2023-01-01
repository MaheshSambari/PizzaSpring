package com.pizzaapplication.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pizzaapplication.exception.AdminNotFoundException;
import com.pizzaapplication.exception.SuccessMessage;
import com.pizzaapplication.entity.Admin;
import com.pizzaapplication.exception.UserNotFoundException;
import com.pizzaapplication.service.AdminLoginService;
@RestController
public class AdminLoginController {
    @Autowired
    private AdminLoginService service;
    
    
      @RequestMapping(value="/adminlogin", method=RequestMethod.GET)
      @ResponseBody
      @Valid 
      public ResponseEntity<SuccessMessage> adminLogin(int adminId, String adminPassword)
      { 
          String tr=service.adminLogin(adminId, adminPassword);
          SuccessMessage success = new SuccessMessage();
          success.setSuccessCode(200);
          success.setSuccessCodeDescription("Good Request");
          success.setSuccessMessage(tr);
          return new ResponseEntity<>(success,HttpStatus.OK);
       }
     


    @RequestMapping(value="/adminpasswordreset", method=RequestMethod.PUT) 
    @ResponseBody
    public ResponseEntity<SuccessMessage> updateAdminPass( int adminId, String adminPassword)
    {
        String tr=service.updateAdminPass(adminId, adminPassword);
        SuccessMessage success = new SuccessMessage();
        success.setSuccessCode(200);
        success.setSuccessCodeDescription("Good Request");
        success.setSuccessMessage(tr);
        return new ResponseEntity<>(success,HttpStatus.OK);
        
    }
}