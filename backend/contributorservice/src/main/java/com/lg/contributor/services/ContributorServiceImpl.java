package com.lg.contributor.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lg.contributor.entity.ContributorEntity;
import com.lg.contributor.entity.CourseEntity;
import com.lg.contributor.model.AuthRequest;
import com.lg.contributor.model.Contributor;
import com.lg.contributor.model.Course;
import com.lg.contributor.repository.ContributorRepository;
import com.lg.contributor.repository.CourseRepository;

@Service
public class ContributorServiceImpl implements ContributorService {
	
	@Autowired
	private ContributorRepository contributorRepository;
	
	@Autowired
	private CourseRepository courseRepository;

	public ContributorServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Contributor createContributor(Contributor contributor) {
		ContributorEntity ce = new ContributorEntity();
		BeanUtils.copyProperties(contributor, ce);
		contributorRepository.save(ce);
		return contributor;
	}

	@Override
	public Contributor update(String username, Contributor contributor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Contributor login(AuthRequest authRequest) {
		ContributorEntity ce1 = null;
		Optional<ContributorEntity> c = contributorRepository.findById(authRequest.getUsername());
		if(c.isPresent()) {
			ce1 = c.get();
			if(ce1.getPassword().equals(authRequest.getPassword())) {
				Contributor contributor = new Contributor();
				BeanUtils.copyProperties(ce1, contributor);
				return contributor;
			}
		}
		return null;
	}

	@Override
	public Course addCourse(Course course) {
		CourseEntity ce = new CourseEntity();
		BeanUtils.copyProperties(course, ce);
		courseRepository.save(ce);
		course.setId(ce.getId());
		return course;
	}

	@Override
	public List<Course> getAllCourses() {
		List<CourseEntity> courses = courseRepository.findAll();
		List<Course> allCourses = new ArrayList<Course>();
		for(CourseEntity ce: courses) {
			Course c = new Course();
			BeanUtils.copyProperties(ce, c);
			c.setId(ce.getId());
			allCourses.add(c);
		}
		return allCourses;
	}

	@Override
	public void removeCourse(Integer id) {
		courseRepository.deleteById(id);
	}

}
