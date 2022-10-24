package com.school.controller;


import com.school.entity.SchoolApi;
import com.school.exception.SchoolException;
import com.school.service.SchoolService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@Controller 
@RequestMapping(path="/school")
@AllArgsConstructor
public class SchoolController {

	private SchoolService schoolService;

	@PostMapping(path="/registerSchool")
	  public @ResponseBody SchoolApi registerSchool (@RequestBody SchoolApi schoolApi) throws SchoolException {
		return schoolService.addNewSchool(schoolApi);
	  }
}






