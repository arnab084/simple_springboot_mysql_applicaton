package com.school.users;

import java.nio.charset.Charset;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	
	public String addNewUser (
			   String firstName, String lastName, String username, String password, 
			   String email, String address, String phone) {
	    User n = new User(firstName, lastName, username, password, email, address, phone);
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
	
	public boolean emailExists (String email) throws UserException {
		List<User> objUser = userRepository.findByEmail(email);
		if(objUser.size()>0) {
			throw new UserException("Email Already Exists !!!");
		}
		return false;
	}
	
	public User login (String username, String password) throws UserException {
		User objUser = userRepository.login(username, password);
		if(objUser == null) {
			throw new UserException("Login Failed");
		}
		return objUser;
	}

	public void addAutenticationToken(User objUser) {
		objUser.setAuthenticationToken(getRandomToken());
		userRepository.save(objUser);
		
	}
	
	
	public String getRandomToken() {
		
		Random r = new Random();
		
		IntStream i1 = r.ints(65, 90).limit(5);
		IntStream i2 = r.ints(48, 57).limit(5);
		IntStream i3 = r.ints(97, 122).limit(5);
		
		String generatedString = IntStream.concat(IntStream.concat(i1,i2),i3).boxed().sorted((o1, o2) -> new Random().nextInt(2)-1)
	    	      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
	    	      .toString();;
	    	      
	    return generatedString;
		
		
	}
	
	

}
