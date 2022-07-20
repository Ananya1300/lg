package com.lg.user.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lg.user.dto.AuthRequest;
import com.lg.user.model.User;
import com.lg.user.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;

	@Override
	public User createUser(User user) {
		userRepo.save(user);
		return user;
	}

	@Override
	public User login(AuthRequest authRequest) {
		User ue = null;
		Optional<User> u = userRepo.findById(authRequest.getUsername());
		if (u.isPresent()) {
			ue = u.get();
			if (ue.getPassword().equals(authRequest.getPassword())) {
				return ue;
			}
		}
		return null;
	}

	@Override
	public List<User> getUsers() {
		return userRepo.findAll();
	}

}
