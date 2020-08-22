package com.school.users;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.school.users.requestbean.LoginBean;
import com.school.users.requestbean.RegistrationBean;


@CrossOrigin(origins = "http://localhost:4200")
@Controller 
@RequestMapping(path="/user") 
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@PostMapping(path="/register")
	  public @ResponseBody String register (@RequestBody RegistrationBean user) throws UserException {
			
		userService.usernameExists(user.getUsername());
		userService.emailExists(user.getEmail());
		userService.phoneExists(user.getPhone());
		userService.addNewUser(user);
		
	    return "User Saved Successfully !!!";
	  }
	  
	  @PostMapping(path="/login") 
	  public @ResponseBody User login (@RequestBody LoginBean user) throws UserException{
		  	User objUser = new User(user);
  			
		  	userService.login(objUser);
    		userService.addAutenticationToken(objUser);
    		userService.removePasword(objUser);
		  	return objUser;
	  }
	  
	  @GetMapping(path="/getAllUsers") 
	  public @ResponseBody Iterable<User> getAllUsers () {
		Iterable<User> objUserList = userService.getAllUsers();
	    return objUserList;
	  }

}


