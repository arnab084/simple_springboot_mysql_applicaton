package com.school.entity;

import lombok.*;

import javax.persistence.*;

@Entity 
@Table(name = "schoolApi")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SchoolApi {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(unique = true)
  	private School school;

	private String api;

}
