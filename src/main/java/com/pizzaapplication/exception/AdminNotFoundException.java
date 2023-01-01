package com.pizzaapplication.exception;

public class AdminNotFoundException extends RuntimeException {
	
    public AdminNotFoundException(int str) {
    	
        super("Could not find Admin with Admin Id " + str);
    }
    
 public AdminNotFoundException() {
    	
        super("Admin with this Admin Id  password is not correct");
    }
}