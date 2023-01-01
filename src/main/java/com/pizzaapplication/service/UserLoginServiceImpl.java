package com.pizzaapplication.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pizzaapplication.entity.Customer;
import com.pizzaapplication.entity.UserLogin;
import com.pizzaapplication.exception.AdminNotFoundException;
import com.pizzaapplication.exception.UserNotFoundException;
import com.pizzaapplication.repository.CustomerRepository;
import com.pizzaapplication.repository.UserLoginRepository;

@Service
@Transactional
public class UserLoginServiceImpl implements UserLoginService {
	@Autowired
	private UserLoginRepository repository;
	@Autowired
	private CustomerRepository crepository;
    String out;
	@Override
	public int userLogin(int userId, String userPassword) throws UserNotFoundException {
        Optional<UserLogin> u = repository.findById(userId);
        if(u.isPresent()) {
        	Optional<UserLogin> u1 = repository.findByUserIdAndUserPassword(userId,userPassword);
        	if(u1.isPresent()){
        		Customer c=crepository.findByUserModel(userId).get();
        		return c.getCustomerId();
        	}
            else throw new UserNotFoundException();
        }
        else throw new UserNotFoundException(userId);
	}
	
	
	@Override
	public String updateUserPass(int userId, String userPassword) throws UserNotFoundException {
		Optional<UserLogin> u = repository.findById(userId);
        if(u.isPresent()) {
            repository.userPassReset(userId,userPassword);
            out = "Your password reset is Succesful";
            return out;
        }
        else throw new UserNotFoundException(userId);
	}

	
}
