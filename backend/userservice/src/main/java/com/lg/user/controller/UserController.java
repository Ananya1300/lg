package com.lg.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lg.user.dto.AuthRequest;
import com.lg.user.feignrest.ContributorRestUser;
import com.lg.user.model.Course;
import com.lg.user.model.User;
import com.lg.user.services.UserService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private ContributorRestUser crUser;

	@GetMapping("/welcome")
	public User isWorking() {
		return new User();
	}

	@PostMapping("/register")
	public User createUser(@RequestBody User user) {
		return userService.createUser(user);
	}

	@PostMapping("/login")
	public User login(@RequestBody AuthRequest authRequest) {
		return userService.login(authRequest);
	}

	@GetMapping("/courses/all")
	public List<Course> getCourses() {
		return crUser.getAllCourses();
	}

	@GetMapping("/users/all")
	public List<User> getUsers() {
		return userService.getUsers();
	}
	
//	public List<User> registerCourse(String username, Course course) {
//		
//	}
//	

}
