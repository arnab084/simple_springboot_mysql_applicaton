package com.school.users.entity;

import org.springframework.data.jpa.repository.JpaRepository;


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface LoginRepository extends JpaRepository<UserLogin , Integer> {
	
	UserLogin findByUsername(String username);
		
}