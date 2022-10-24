package com.school.service;

import com.school.entity.SchoolClass;
import com.school.repo.SchoolClassRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class SchoolClassService {

	SchoolClassRepository schoolClassRepository;

	public SchoolClass addNewSchoolClass (SchoolClass schoolClass) {
		return schoolClassRepository.save(schoolClass);
	}

	public Iterable<SchoolClass> getAllSchoolClasses() {
		return schoolClassRepository.findAll();
	}




	
	
	

}
