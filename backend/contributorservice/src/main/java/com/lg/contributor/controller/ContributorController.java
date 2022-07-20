package com.lg.contributor.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lg.contributor.dto.AuthRequest;
import com.lg.contributor.dto.CourseAddRequest;
import com.lg.contributor.dto.CourseAddResponse;
import com.lg.contributor.dto.CourseEditRequest;
import com.lg.contributor.dto.CourseEditResponse;
import com.lg.contributor.dto.UserCoursesResponse;
import com.lg.contributor.model.Contributor;
import com.lg.contributor.services.ContributorService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/contributor")
public class ContributorController {
	@Autowired
	private ContributorService contributorService;

	@PostMapping("/register")
	public Contributor register(@RequestBody Contributor c) {
		return contributorService.createContributor(c);
	}
	
	@PostMapping("/login")
	public Contributor login(@RequestBody AuthRequest authRequest) {
		return contributorService.login(authRequest);
	}
	
	@PostMapping("/{username}/course/add")
	public CourseAddResponse addCourse(@PathVariable(name = "username") String username, @RequestBody CourseAddRequest car) {
		return contributorService.addCourse(username, car);
	}
	
	@GetMapping("/{username}/course/all")
	public List<UserCoursesResponse> getAllCourses(@PathVariable(name = "username") String username) {
		return contributorService.getUserCourses(username);
	}
	
	@PutMapping("/{username}/course/edit/{id}")
	public CourseEditResponse editCourse(@PathVariable(name = "username") String username,@PathVariable(name = "id") Integer id, @RequestBody CourseEditRequest cer) {
		return contributorService.editCourse(username, id, cer);
	}
	
	@DeleteMapping("/{username}/course/delete/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteCourse(@PathVariable(name = "username") String username, @PathVariable(name = "id") Integer id) {
		
		boolean deleted = false;
        deleted = contributorService.removeCourse(username, id);
        Map<String,Boolean> response = new HashMap<>();
        response.put("deleted", deleted);
        return ResponseEntity.ok(response);
	}
}
