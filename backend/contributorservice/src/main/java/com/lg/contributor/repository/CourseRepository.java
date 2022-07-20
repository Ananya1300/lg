package com.lg.contributor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lg.contributor.dto.UserCoursesResponse;
import com.lg.contributor.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
	
	@Query("select c.id,c.title,c.description,c.estimatedTime,c.contributor from Course c where c.contributor=?1")
	List<UserCoursesResponse> getUserCourses(String username);
	
}
