package com.pizzaapplication.service;

import java.util.List;

import com.pizzaapplication.entity.UserLogin;

public interface UserLoginService {

	public int userLogin(int userId, String userPassword);

	public String updateUserPass(int userId, String userPassword);
	
}
