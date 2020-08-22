package com.school.users;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.users.requestbean.RegistrationBean;
import com.school.utility.CommonUtility;


@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	
	public String addNewUser (RegistrationBean user) {
	    User n = new User(user);
	    userRepository.save(n);
	    return "Saved";
	}
	
	public boolean usernameExists (String username) throws UserException {
		User objUser = userRepository.findByUsername(username);
		if(objUser!=null) {
			throw new UserException("User Already Exists !!!");
		}
		return false;
	}
	
	
	public boolean phoneExists (String phone) throws UserException {
		User objUser = userRepository.findByPhone(phone);
		if(objUser!=null) {
			throw new UserException("Phone Number Exists !!!");
		}
		return false;
	}
	
	
	public boolean emailExists (String email) throws UserException {
		List<User> objUser = userRepository.findByEmail(email);
		if(objUser.size()>0) {
			throw new UserException("Email Already Exists !!!");
		}
		return false;
	}
	
	public void login (User user) throws UserException {
		User objUser = userRepository.login(user.getUsername(), user.getPassword());
		if(objUser == null) {
			throw new UserException("Login Failed");
		}
		user.copy(objUser);
	}

	public void addAutenticationToken(User objUser) {
		objUser.setAuthenticationToken(CommonUtility.getRandomToken());
		userRepository.save(objUser);
		
	}
	
	public void removePasword(User objUser){
		objUser.setPassword(null);
	}
	
	
	public Iterable<User> getAllUsers() {
		return userRepository.findAll();
	}
	
	
	

	
	
	

}
