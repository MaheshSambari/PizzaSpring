package com.pizzaapplication.entity;

import java.time.LocalDate;

public class PlaceOrder {

	private int orderId;
    private String orderType;
    private String orderDescription;
	private int orderCustomerId;
	
	private int pizzaId;
//	private String pizzaType;
//	private String pizzaName;
//	private String pizzaDescription;
//	private double pizzaCost;

    private int pizzaorderId;
    private LocalDate orderDate;
    private String transactionMode;
    private String size;
    private int quantity;
    private double totalCost;
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getOrderType() {
		return orderType;
	}
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	public String getOrderDescription() {
		return orderDescription;
	}
	public void setOrderDescription(String orderDescription) {
		this.orderDescription = orderDescription;
	}
	public int getOrderCustomerId() {
		return orderCustomerId;
	}
	public void setOrderCustomerId(int orderCustomerId) {
		this.orderCustomerId = orderCustomerId;
	}
	public int getPizzaId() {
		return pizzaId;
	}
	public void setPizzaId(int pizzaId) {
		this.pizzaId = pizzaId;
	}
	public int getPizzaorderId() {
		return pizzaorderId;
	}
	public void setPizzaorderId(int pizzaorderId) {
		this.pizzaorderId = pizzaorderId;
	}
	public LocalDate getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}
	public String getTransactionMode() {
		return transactionMode;
	}
	public void setTransactionMode(String transactionMode) {
		this.transactionMode = transactionMode;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}
    
    
    




	

}
