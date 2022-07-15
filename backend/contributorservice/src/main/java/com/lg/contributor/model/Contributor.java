package com.lg.contributor.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contributor {
	private String username;
	private String password;
	private String firstname;
	private String lastname;
	private String email;
	private Integer experience;
}
