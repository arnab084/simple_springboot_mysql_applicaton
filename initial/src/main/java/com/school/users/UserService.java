package com.school.users;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.users.entity.LoginRepository;
import com.school.users.entity.RegistrationRepository;
import com.school.users.entity.UserLogin;
import com.school.users.entity.UserRegistration;
import com.school.users.requestbean.LoginBean;
import com.school.utility.CommonUtility;


@Service
public class UserService {
	
	@Autowired
	LoginRepository loginRepository;
	
	@Autowired
	RegistrationRepository registrationRepository;
	
	
	public String addNewUser (UserRegistration user) {
	    registrationRepository.save(user);
	    return "Saved";
	}
	
	public void usernameExists (String username) throws UserException {
		if(loginRepository.findByUsername(username)!=null) {
			throw new UserException("User Already Exists !!!");
		}
	}
	
	
	public void phoneExists (String phone) throws UserException {
		if(registrationRepository.findByPhone(phone)!=null) {
			throw new UserException("Phone Number Exists !!!");
		}
	}
	
	
	public void emailExists (String email) throws UserException {
		if(registrationRepository.findByEmail(email)!=null) {
			throw new UserException("Email Already Exists !!!");
		}
	}
	
	public UserRegistration login (LoginBean user) throws UserException {
		UserRegistration objUser = registrationRepository.login(user.getUsername(), user.getPassword());
		if(objUser == null) {
			throw new UserException("Login Failed");
		}
		return objUser;
	}

	public void addLoginEntryWithAuthenticationToken(UserRegistration user) {
		
		user.getUserLogin().setAuthenticationToken(CommonUtility.getRandomToken());
		registrationRepository.save(user);
		
	}
	
	
	public Iterable<UserRegistration> getAllUsers() {
		return registrationRepository.findAll();
	}
	
	
	

	
	
	

}
