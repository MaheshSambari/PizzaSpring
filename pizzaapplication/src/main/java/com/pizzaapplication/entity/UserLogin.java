package com.pizzaapplication.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="userlogin")
public class UserLogin {
	@Id
	@SequenceGenerator(name = "user", sequenceName = "user_sequence", initialValue = 20000, allocationSize = 1)
    @GeneratedValue(generator = "user", strategy = GenerationType.SEQUENCE)  	
	@Column(name="userid")
	private int userId;
	@Column(name="userpassword")
	@NotNull(message ="password is must")
	private String userPassword;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserpassword() {
		return userPassword;
	}
	public void setUserpassword(String userpassword) {
		this.userPassword = userpassword;
	}
	
}
