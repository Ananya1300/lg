package com.lg.user.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "course")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Course {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "creator")
	private String creator;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "estimated_time")
	private Integer estimatedTime;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<User> users;

	public Course(String title, String creator, String description, Integer estimatedTime) {
		super();
		this.title = title;
		this.creator = creator;
		this.description = description;
		this.estimatedTime = estimatedTime;
	}
	
	

}
