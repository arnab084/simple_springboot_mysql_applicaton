package com.school.entity;

import com.school.enums.UserRole;
import lombok.*;

import javax.persistence.*;

@Entity 
@Table(name = "user")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(unique = true)
  	private SchoolClass school;

	private String firstName;

	private String lastName;

	private String email;

	private UserRole userRole;

	private String username;

	private String password;

}
