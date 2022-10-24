package com.school.controller;


import com.school.entity.SchoolClass;
import com.school.exception.SchoolException;
import com.school.service.SchoolClassService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@Controller 
@RequestMapping(path="/class")
@AllArgsConstructor
public class SchoolClassController {

	private SchoolClassService schoolClassService;

	@PostMapping(path="/addClass")
	  public @ResponseBody SchoolClass addClass (@RequestBody SchoolClass schoolClass) throws SchoolException {
		return schoolClassService.addNewSchoolClass(schoolClass);
	  }
}






