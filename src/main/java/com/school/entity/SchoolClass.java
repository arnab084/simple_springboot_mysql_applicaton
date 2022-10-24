package com.school.entity;

import lombok.*;

import javax.persistence.*;

@Entity 
@Table(name = "schoolClass")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SchoolClass {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
  	private School school;

	private String name;

	private String section;

}
