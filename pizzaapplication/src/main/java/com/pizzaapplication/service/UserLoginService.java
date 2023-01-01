package com.pizzaapplication.service;

import java.util.List;

import com.pizzaapplication.entity.UserLogin;

public interface UserLoginService {

	String userLogin(int userId, String userPassword);

	String updateUserPass(int userId, String userPassword);
	
}
