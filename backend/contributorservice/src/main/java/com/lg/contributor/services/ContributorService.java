package com.lg.contributor.services;

import java.util.List;

import com.lg.contributor.model.AuthRequest;
import com.lg.contributor.model.Contributor;
import com.lg.contributor.model.Course;

public interface ContributorService {
	Contributor createContributor(Contributor contributor);
	Contributor update(String username, Contributor contributor);
	Contributor login(AuthRequest authRequest);
	Course addCourse(Course course);
	List<Course> getAllCourses();
	void removeCourse(Integer id);
}
