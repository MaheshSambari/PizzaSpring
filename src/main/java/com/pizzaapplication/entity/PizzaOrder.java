package com.pizzaapplication.entity;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="pizzaorder")
public class PizzaOrder{
        @Id
        @SequenceGenerator(name = "pizzaorder", sequenceName = "pizzaorder_sequence", initialValue = 40000, allocationSize = 1)
        @GeneratedValue(generator = "pizzaorder", strategy = GenerationType.SEQUENCE)  
        @Column(name="pizzaorderid")
        private int pizzaorderId;
        
        @Column(name="orderdate")
        @NotNull(message="date is must")
        private LocalDate orderDate;
        
        @Column(name="transactionmode")
        @NotNull(message="transactionmode is must")
        private String transactionMode;
        
        @Min(message="quantity must be 1 or above",value=1)
        private int quantity;
  		private String size;
        @Column(name="totalcost")
        private double totalCost;

		@ManyToOne(cascade = CascadeType.ALL)
        @JoinColumn(name = "pizzaid")
        private Pizza pizza;

        @ManyToOne(cascade = CascadeType.ALL)
        @JoinColumn(name = "orderid")
        private Order order;
        
        // getters and setters

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
		public int getQuantity() {
			return quantity;
		}
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
		public String getSize() {
			return size;
		}
		public void setSize(String size) {
			this.size = size;
		}
		public double getTotalCost() {
			return totalCost;
		}
		public void setTotalCost(double totalCost) {
			this.totalCost = totalCost;
		}
		public Pizza getPizza() {
			return pizza;
		}
		public void setPizza(Pizza pizza) {
			this.pizza = pizza;
		}
		public Order getOrder() {
			return order;
		}
		public void setOrder(Order order) {
			this.order = order;
		}
		public PizzaOrder(LocalDate orderDate, String transactionMode, int quantity, String size, double totalCost, Pizza pizza, Order order) {
			this.orderDate = orderDate;
			this.transactionMode = transactionMode;
			this.quantity = quantity;
			this.size = size;
			this.totalCost = totalCost;
			this.pizza = pizza;
			this.order = order;
		}
		public PizzaOrder() {
		}
  }