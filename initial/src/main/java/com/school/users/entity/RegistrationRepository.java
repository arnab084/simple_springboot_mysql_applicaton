package com.school.users.entity;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;



public interface RegistrationRepository extends JpaRepository<UserRegistration , Integer> {
	
	
	UserRegistration findByEmail(String email);
	
	
	UserRegistration findByPhone(String phone);
	
	
	@Query("SELECT ur FROM UserRegistration ur where ur.userLogin.username = :username and ur.password = :password")
	UserRegistration login(@Param("username") String username,@Param("password") String password);
	
	

}
