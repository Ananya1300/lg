package com.lg.user.feignrest;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.lg.user.model.Course;

@FeignClient(name = "CONTRIBUTOR-SERVICE")
public interface ContributorRestUser {
	
	@GetMapping("/contributor/getAllCourses")
	public List<Course> getAllCourses();

}
