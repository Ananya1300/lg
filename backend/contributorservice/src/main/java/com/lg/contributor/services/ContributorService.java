package com.lg.contributor.services;

import java.util.List;

import com.lg.contributor.dto.AuthRequest;
import com.lg.contributor.dto.CourseAddRequest;
import com.lg.contributor.dto.CourseAddResponse;
import com.lg.contributor.dto.CourseEditRequest;
import com.lg.contributor.dto.CourseEditResponse;
import com.lg.contributor.dto.UserCoursesResponse;
import com.lg.contributor.model.Contributor;

public interface ContributorService {
	Contributor createContributor(Contributor contributor);
	Contributor login(AuthRequest authRequest);
	boolean removeCourse(String username, Integer id);
	CourseAddResponse addCourse(String username, CourseAddRequest car);
	CourseEditResponse editCourse(String username, Integer id, CourseEditRequest cer);
	List<UserCoursesResponse> getUserCourses(String username);
}
