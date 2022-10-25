package com.school.controller;


import com.school.entity.Attendance;
import com.school.entity.User;
import com.school.exception.SchoolException;
import com.school.service.AttendanceService;
import com.school.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@Controller 
@RequestMapping(path="/attendance")
@AllArgsConstructor
public class AttendanceController {

	private AttendanceService attendanceService;

	@PostMapping(path="/addAttendance")
	  public @ResponseBody Attendance addAttendance (@RequestBody Attendance attendance) throws SchoolException {
		return attendanceService.addAttendance(attendance);
	  }

	@GetMapping(path="/listAttendance")
	public @ResponseBody Iterable<Attendance> listAttendance () {
		return attendanceService.getAllAttendance();
	}
}






