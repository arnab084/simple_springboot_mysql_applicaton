package com.school.users;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UserRepository extends CrudRepository<User , Integer> {
	
	
	List<User> findByEmail(String email);
	
	
	User findByUsername(String username);
	
	
	User findByPhone(String phone);
	
	
	
	@Query("SELECT u FROM User u where u.username = :username and u.password = :password") 
	User login(@Param("username") String username, @Param("password") String password);
	
	
	
	
	
	

	
	
}