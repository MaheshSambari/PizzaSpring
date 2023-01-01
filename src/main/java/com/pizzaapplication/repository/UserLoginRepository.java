package com.pizzaapplication.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.pizzaapplication.entity.UserLogin;

public interface UserLoginRepository extends JpaRepository<UserLogin, Integer> {

//	@Query("select u from UserLogin u where userId=?1 and userPassword=?2")
//	Optional<UserLogin> userLogin(int userId, String userPassword);
	
	public Optional<UserLogin> findByUserIdAndUserPassword(int userId, String userPassword);

	@Query("update UserLogin u  set  userPassword=?2 where userId=?1")
	@Modifying
	void userPassReset(int userId, String userPassword);

}
