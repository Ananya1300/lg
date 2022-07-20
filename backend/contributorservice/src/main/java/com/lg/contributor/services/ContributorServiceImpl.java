package com.lg.contributor.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lg.contributor.dto.AuthRequest;
import com.lg.contributor.dto.CourseAddRequest;
import com.lg.contributor.dto.CourseAddResponse;
import com.lg.contributor.dto.CourseEditRequest;
import com.lg.contributor.dto.CourseEditResponse;
import com.lg.contributor.dto.UserCoursesResponse;
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
	}

	@Override
	public Contributor createContributor(Contributor contributor) {
		contributorRepository.save(contributor);
		return contributor;
	}

	@Override
	public Contributor login(AuthRequest authRequest) {
		Contributor contributor = null;
		Optional<Contributor> c = contributorRepository.findById(authRequest.getUsername());
		if(c.isPresent()) {
			contributor = c.get();
			if(contributor.getPassword().equals(authRequest.getPassword())) {
				return contributor;
			}
		}
		return null;
	}

	@Override
	public CourseAddResponse addCourse(String username, CourseAddRequest car) {
		Course c = new Course();
		c.setTitle(car.getTitle());
		c.setDescription(car.getDescription());
		c.setEstimatedTime(car.getEstimatedTime());
		
		Optional<Contributor> con = contributorRepository.findById(username);
		if(con.isPresent()) {
			Contributor cont = con.get();
			c.setContributor(cont);
			Course k = courseRepository.save(c);
			CourseAddResponse cart = new CourseAddResponse();
			cart.setId(k.getId());
			cart.setTitle(k.getTitle());
			cart.setDescription(k.getDescription());
			cart.setEstimatedTime(k.getEstimatedTime());
			cart.setUsername(username);
			return cart;
		}
		return null;
	}

	
	@Override
	public CourseEditResponse editCourse(String username, Integer id, CourseEditRequest cer) {
		Optional<Course> c = courseRepository.findById(id);
		CourseEditResponse car = null;
		if(c.isPresent()) {
			
			Course t = c.get();
			t.setTitle(cer.getTitle());
			t.setDescription(cer.getDescription());
			t.setEstimatedTime(cer.getEstimatedTime());
			
			Course k = courseRepository.save(t);
			
			car = new CourseEditResponse();
			car.setId(k.getId());
			car.setTitle(k.getTitle());
			car.setDescription(k.getDescription());
			car.setEstimatedTime(k.getEstimatedTime());
			car.setUsername(username);

		}
		return car;
	}

	@Override
	public boolean removeCourse(String username, Integer id) {
		courseRepository.deleteById(id);
		return true;
	}

	@Override
	public List<UserCoursesResponse> getUserCourses(String username) {
		// TODO Auto-generated method stub
		return courseRepository.getUserCourses(username);
	}

}
