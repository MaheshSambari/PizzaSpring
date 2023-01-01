package com.pizzaapplication.service;

public interface AdminLoginService {

	String adminLogin(int adminId, String adminPassword);
	String updateAdminPass(int adminId, String adminPassword);
	
}
