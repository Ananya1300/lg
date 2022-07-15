package com.lg.contributor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lg.contributor.entity.CourseEntity;

@Repository
public interface CourseRepository extends JpaRepository<CourseEntity, Integer> {
	
}
