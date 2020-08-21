package com.school.users;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@CrossOrigin(origins = "http://localhost:4200")
@Controller 
@RequestMapping(path="/user") 
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@PostMapping(path="/register")
	  public @ResponseBody String register (
			  @RequestParam String firstName, @RequestParam String lastName, @RequestParam String userName, 
			  @RequestParam String password, @RequestParam String email, @RequestParam String address, 
			  @RequestParam String phone) {
		try {
			userService.usernameExists(userName);
			userService.emailExists(email);
			userService.phoneExists(phone);
			userService.addNewUser(firstName, lastName, userName, password, email, address, phone);
		} catch(UserException e) {
			return e.getMessage();
		} catch(Exception e) {
			return e.getMessage();
		}
		
	    return "User Saved Successfully !!!";
	  }
	  
	  @PostMapping(path="/login") 
	  public @ResponseBody Object login (@RequestParam String username, @RequestParam String password) throws UserException{
  		User objUser = userService.login(username, password);
    	userService.addAutenticationToken(objUser);
		
	    return objUser;
	  }
	  
	  @GetMapping(path="/getAllUsers") 
	  public @ResponseBody Iterable<User> getAllUsers () {
		Iterable<User> objUserList = userService.getAllUsers();
	    return objUserList;
	  }

}


