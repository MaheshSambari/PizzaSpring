package com.pizzaapplication.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pizzaapplication.entity.Admin;
import com.pizzaapplication.exception.AdminNotFoundException;
import com.pizzaapplication.exception.UserNotFoundException;
import com.pizzaapplication.repository.AdminLoginRepository;

@Service
@Transactional
public class AdminServiceImplementation implements AdminLoginService{
	@Autowired
	private AdminLoginRepository repository;
    String out;
    
	@Override
	public String adminLogin(int adminId, String adminPassword) throws AdminNotFoundException {
        Optional<Admin> u = repository.findById(adminId);
        if(u.isPresent()) {
        	Optional<Admin> u1 = repository.adminLogin(adminId,adminPassword);
        	if(u1.isPresent())
        	{
        		out = "Login Succesful";
        	    return out;
        	}
            else throw new AdminNotFoundException();
        }
        else throw new AdminNotFoundException(adminId);
		
	}
	@Override
	public String updateAdminPass(int adminId, String adminPassword) throws AdminNotFoundException {
		Optional<Admin> u = repository.findById(adminId);
        if(u.isPresent()) {
            repository.adminPassReset(adminId,adminPassword);
            out = "Your password reset is Succesful";
            return out;
        }
        else throw new AdminNotFoundException(adminId);
	}
}
