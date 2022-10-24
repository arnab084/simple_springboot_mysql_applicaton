package com.school.entity;

import lombok.*;

import javax.persistence.*;

@Entity 
@Table(name = "classNotes")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClassNotes {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne(cascade = CascadeType.ALL)
  	private SchoolClass schoolClass;

	@Lob
	@Basic(fetch = FetchType.LAZY)
	private byte[] classNote;


}
