package com.school.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity 
@Table(name = "attendance")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Attendance {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(unique = true)
  	private User user;

	private LocalDate date;

}
