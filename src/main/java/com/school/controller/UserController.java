package com.school.controller;


import com.school.entity.User;
import com.school.exception.SchoolException;
import com.school.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@Controller 
@RequestMapping(path="/user")
@AllArgsConstructor
public class UserController {

	private UserService userService;

	@PostMapping(path="/addNewUser")
	  public @ResponseBody User addNewUser (@RequestBody User user) throws SchoolException {
		return userService.addNewUser(user);
	  }

	@GetMapping(path="/listUsers")
	public @ResponseBody Iterable<User> listUsers () {
		return userService.getAllUsers();
	}
}






