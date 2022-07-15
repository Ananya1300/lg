package com.lg.user.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String title;
	private String creator;
	private String description;
	private Integer estimatedTime;
}
