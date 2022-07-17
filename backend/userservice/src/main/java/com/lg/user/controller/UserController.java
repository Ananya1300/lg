package com.lg.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lg.user.feignrest.ContributorRestUser;
import com.lg.user.model.AuthRequest;
import com.lg.user.model.Course;
import com.lg.user.model.User;
import com.lg.user.services.UserService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/user")
public class UserController {

	private UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@Autowired
	private ContributorRestUser crUser;

	@GetMapping("/welcome")
	public String isWorking() {
		return "Working";
	}

	@PostMapping("/register")
	public User createUser(@RequestBody User user) {
		return userService.createUser(user);
	}

	@PostMapping("/login")
	public User login(@RequestBody AuthRequest authRequest) {
		return userService.login(authRequest);
	}

	@PutMapping("/update/{username}")
	public ResponseEntity<User> updateUser(@PathVariable String username, @RequestBody User user) {
		user = userService.updateUser(username, user);
		return ResponseEntity.ok(user);
	}
	
	@GetMapping("/courses/all")
	public List<Course> getCourses() {
		return crUser.getAllCourses();
	}
	
	@GetMapping("/users/all")
	public List<User> getUsers()
	{
		return userService.getUsers();
	}
}
