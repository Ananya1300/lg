package com.lg.contributor.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "course")
public class CourseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String title;
	private String creator;
	private String description;
	private Integer estimatedTime;
}
