package com.school.repo;


import com.school.entity.SchoolApi;
import org.springframework.data.jpa.repository.JpaRepository;



public interface SchoolApiRepository extends JpaRepository<SchoolApi, Integer> {
	
//	@Query("SELECT ur FROM UserRegistration ur where ur.userLogin.username = :username and ur.password = :password")
//	UserRegistration login(@Param("username") String username,@Param("password") String password);
	
	

}
