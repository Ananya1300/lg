package com.lg.contributor.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "contributor")
public class ContributorEntity {
	@Id
	private String username;
	private String password;
	private String firstname;
	private String lastname;
	private String email;
	private Integer experience;
}
