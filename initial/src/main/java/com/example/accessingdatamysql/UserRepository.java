package com.example.accessingdatamysql;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UserRepository extends CrudRepository<User, Integer> {
	
	
	List<User> findByEmail(String email);
	
	List<User> findByName(String name);
	
	@Query("SELECT u FROM User u where u.name = :name") 
    List<User> findIdByName(@Param("name") String name);
	

}