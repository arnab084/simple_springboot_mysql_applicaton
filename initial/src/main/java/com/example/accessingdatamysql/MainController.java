package com.example.accessingdatamysql;

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
@Controller // This means that this class is a Controller
@RequestMapping(path="/demo") // This means URL's start with /demo (after Application path)
public class MainController {
  @Autowired // This means to get the bean called userRepository
  private UserRepository userRepository;

  @PostMapping(path="/addNewUser") // Map ONLY POST Requests
  public @ResponseBody String addNewUser (@RequestParam String name
      , @RequestParam String email) {

    User n = new User();
    n.setName(name);
    n.setEmail(email);
    userRepository.save(n);
    return "Saved";
  }
  
  @PostMapping(path="/findUserByName") // Map ONLY POST Requests
  public @ResponseBody List<User> findUserByName (@RequestParam String name) {

    return userRepository.findIdByName(name);
  }
  
  
  @PostMapping(path="/findUserByEmail") // Map ONLY POST Requests
  public @ResponseBody List<User> findUserByEmail(@RequestParam String email) {

    return userRepository.findByEmail(email);
  }
  

  @GetMapping(path="/all")
  public @ResponseBody Iterable<User> getAllUsers() {
    // This returns a JSON or XML with the users
    return userRepository.findAll();
  }
}