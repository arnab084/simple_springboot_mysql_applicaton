package com.school.users;


import com.school.users.entity.UserLogin;
import com.school.users.entity.UserRegistration;
import com.school.users.requestbean.LoginBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



@CrossOrigin(origins = "http://localhost:4200")
@Controller 
@RequestMapping(path="/user") 
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@PostMapping(path="/register")
	  public @ResponseBody String register (@RequestBody UserRegistration user) throws UserException  {
			
		userService.usernameExists(user.getUserLogin().getUsername());
		userService.emailExists(user.getEmail());
		userService.phoneExists(user.getPhone());
		userService.addNewUser(user);
		
	    return "User Saved Successfully !!!";
	  }
	  
	  @PostMapping(path="/login") 
	  public @ResponseBody
	  UserLogin login (@RequestBody LoginBean user) throws UserException{

		  UserRegistration registeredUser =  userService.login(user);
		  userService.addLoginEntryWithAuthenticationToken(registeredUser);
		  	
		  return registeredUser.getUserLogin();
	  }
	  
	  @GetMapping(path="/getAllUsers") 
	  public @ResponseBody Iterable<UserRegistration> getAllUsers () {
		Iterable<UserRegistration> objUserList = userService.getAllUsers();
	    return objUserList;
	  }

}






