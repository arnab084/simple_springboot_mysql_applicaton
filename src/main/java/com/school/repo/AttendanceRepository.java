package com.school.repo;

import com.school.entity.Attendance;
import com.school.entity.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendanceRepository extends JpaRepository<Attendance, Integer> {

}
