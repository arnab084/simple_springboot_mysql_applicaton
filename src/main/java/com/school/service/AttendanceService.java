package com.school.service;

import com.school.entity.Attendance;
import com.school.entity.User;
import com.school.repo.AttendanceRepository;
import com.school.repo.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class AttendanceService {

	AttendanceRepository attendanceRepository;

	public Attendance addAttendance (Attendance attendance) {
		return attendanceRepository.save(attendance);
	}

	public Iterable<Attendance> getAllAttendance() {
		return attendanceRepository.findAll();
	}




	
	
	

}
