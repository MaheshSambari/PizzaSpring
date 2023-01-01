package com.pizzaapplication.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.pizzaapplication.entity.Admin;

public interface AdminLoginRepository extends JpaRepository<Admin,Integer> {

	@Query("select u from Admin u where adminId=?1 and adminPassword=?2")
	public Optional<Admin> adminLogin(int adminId, String adminPassword);

	@Query("update Admin u  set  adminPassword=?2 where adminId=?1")
	@Modifying
	void adminPassReset(int adminId, String adminPassword);
	
}
