package com.pizzaapplication.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="pizza")
public class Pizza {

	@Column(name="pizzaid")
	@Id
	@SequenceGenerator(name = "pizza", sequenceName = "pizza_sequence", initialValue = 30000, allocationSize = 1)
	@GeneratedValue(generator = "pizza", strategy = GenerationType.SEQUENCE)  	
	private int pizzaId;

	@Size(max=20,min=3,message="pizza Type criteria not met")
	@Column(name="pizzatype")
	@NotNull(message = "Pizza type not to be empty")
	private String pizzaType;

	@Size(max=20,min=3,message="pizza name criteria not met")
	@Column(name="pizzaname")
	@NotNull(message = "Pizza name not to be empty")
	private String pizzaName;

	@Size(max=100,min=12,message="pizza Descrption criteria not met")
	@Column(name="pizzadescription")
	@NotNull(message = "pizza Description not to be empty")
	private String pizzaDescription;

	@Column(name="pizzacost")
	@Min (message = "pizza Cost too low Minimum Cost to be 100 Rupees", value = 100)
	@Max (message = "pizza Cost too High Maximum Cost to be 10000 Rupees Only", value = 10000)
	private double pizzaCost;
	
	@Min (message = "pizza quantity should not have negative value", value = 0)
	@Max (message = "pizza quantitys must be 200 or below", value = 200)
	@Column(name="availablequantity")
	private int availableQuantity;

	// getters and setters
	public int getPizzaId() {
		return pizzaId;
	}
	public void setPizzaId(int pizzaId) {
		this.pizzaId = pizzaId;
	}
	public String getPizzaType() {
		return pizzaType;
	}
	public void setPizzaType(String pizzaType) {
		this.pizzaType = pizzaType;
	}
	public String getPizzaName() {
		return pizzaName;
	}
	public void setPizzaName(String pizzaName) {
		this.pizzaName = pizzaName;
	}
	public String getPizzaDescription() {
		return pizzaDescription;
	}
	public void setPizzaDescription(String pizzaDescription) {
		this.pizzaDescription = pizzaDescription;
	}
	public double getPizzaCost() {
		return pizzaCost;
	}
	public void setPizzaCost(double pizzaCost) {
		this.pizzaCost = pizzaCost;
	}
	



	public int getAvailableQuantity() {
		return availableQuantity;
	}
	public void setAvailableQuantity(int availableQuantity) {
		this.availableQuantity = availableQuantity;
	}


	public Pizza() {
	
	}


}