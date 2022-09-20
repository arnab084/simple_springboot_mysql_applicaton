package com.school.users.entity;

import com.school.users.requestbean.LoginBean;
import com.school.users.requestbean.RegistrationBean;

import javax.persistence.*;

@Entity
@Table(name = "database_names")
public class DatabaseNames {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

  	private String name;


  	public DatabaseNames(String name){
  		this.name = name;
	}


}
