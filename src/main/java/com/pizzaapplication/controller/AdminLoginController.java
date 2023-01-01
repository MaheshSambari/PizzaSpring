package com.pizzaapplication.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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


@CrossOrigin(origins="http://localhost:4200")
@RestController
public class AdminLoginController {
    @Autowired
    private AdminLoginService service;
    
    // RESTful API methods for Retrieval operation 
    @RequestMapping(value="/adminlogin", method=RequestMethod.POST) 
    public ResponseEntity<SuccessMessage> adminLogin(@RequestBody Admin admin)
    { 
        String tr=service.adminLogin(admin.getAdminId(),admin.getAdminPassword());
        SuccessMessage success = new SuccessMessage();
        success.setSuccessCode(200);
        success.setSuccessCodeDescription("Good Request");
        success.setSuccessMessage(tr);
        return new ResponseEntity<>(success,HttpStatus.OK);
    }
     
    //RESTful API methods for Update operation 
    @RequestMapping(value="/adminpasswordreset", method=RequestMethod.PUT) 
    public ResponseEntity<SuccessMessage> updateAdminPass( @RequestBody Admin admin)
    { 
        String tr=service.updateAdminPass(admin.getAdminId(),admin.getAdminPassword());
        SuccessMessage success = new SuccessMessage();
        success.setSuccessCode(200);
        success.setSuccessCodeDescription("Good Request");
        success.setSuccessMessage(tr);
        return new ResponseEntity<>(success,HttpStatus.OK);
        
    }
}