package com.lg.contributor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lg.contributor.model.AuthRequest;
import com.lg.contributor.model.Contributor;
import com.lg.contributor.model.Course;
import com.lg.contributor.services.ContributorService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/contributor")
public class ContributorController {
	@Autowired
	private ContributorService contributorService;
	
	@GetMapping("/welcome")
	public String isWorking() {
		return "Working";
	}
	
	@PostMapping("/register")
	public Contributor register(@RequestBody Contributor c) {
		return contributorService.createContributor(c);
	}
	
	@PostMapping("/login")
	public Contributor login(@RequestBody AuthRequest authRequest) {
		return contributorService.login(authRequest);
	}
	
	@PostMapping("/add")
	public Course add(@RequestBody Course course) {
		return contributorService.addCourse(course);
	}
	
	@GetMapping("/getAllCourses")
	public List<Course> getAllCourses() {
		return contributorService.getAllCourses();
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteCourse(@PathVariable Integer id) {
		contributorService.removeCourse(id);
	}
}
