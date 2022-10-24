package com.school.service;

import com.school.entity.User;
import com.school.repo.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class UserService {

	UserRepository userRepository;

	public User addNewUser (User user) {
		return userRepository.save(user);
	}

	public Iterable<User> getAllUsers() {
		return userRepository.findAll();
	}




	
	
	

}
