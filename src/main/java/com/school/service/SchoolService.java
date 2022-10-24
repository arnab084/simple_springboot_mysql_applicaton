package com.school.service;

import com.school.entity.SchoolApi;
import com.school.repo.SchoolApiRepository;
import com.school.repo.SchoolRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class SchoolService {

	SchoolRepository schoolRepository;
	SchoolApiRepository schoolApiRepository;

	public SchoolApi addNewSchool (SchoolApi schoolApi) {
		return schoolApiRepository.save(schoolApi);
	}

	public Iterable<SchoolApi> getAllSchools() {
		return schoolApiRepository.findAll();
	}




	
	
	

}
