package com.school.entity;

import lombok.*;
import javax.persistence.*;

@Entity 
@Table(name = "school")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class School {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

  	private String name;

}
