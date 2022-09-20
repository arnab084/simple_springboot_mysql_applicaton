package com.school.users.entity;

import javax.persistence.*;

@Entity
@Table(name = "table_names")
public class TableNames {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

  	private String name;


}
