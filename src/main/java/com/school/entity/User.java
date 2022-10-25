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

	@ManyToOne
	@JoinColumn(unique = true)
  	private SchoolClass schoolClass;

	private String firstName;

	private String lastName;

	private String email;

	@Enumerated(EnumType.STRING)
	private UserRole userRole;

	private String username;

	private String password;

	public String getPassword(){
		return "******";
	}

}
