package com.lg.user.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.lg.user.entity.UserEntity;
import com.lg.user.model.AuthRequest;
import com.lg.user.model.User;
import com.lg.user.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	private UserRepository userRepo;
	
	public UserServiceImpl(UserRepository userRepo) {
		this.userRepo = userRepo;
	}

	@Override
	public User createUser(User user) {
		UserEntity userEntity = new UserEntity();
		BeanUtils.copyProperties(user, userEntity);
		userRepo.save(userEntity);
		return user;
	}

	@Override
	public User updateUser(String username, User user) {
		UserEntity userEntity = userRepo.findById(username).get();
		userEntity.setFirstname(user.getFirstname());
		userEntity.setLastname(user.getLastname());
		userEntity.setEmail(user.getEmail());
		userEntity.setPassword(user.getPassword());

		userRepo.save(userEntity);
		return user;
	}

	@Override
	public User login(AuthRequest authRequest) {
		UserEntity ue = null;
		Optional<UserEntity> u = userRepo.findById(authRequest.getUsername());
		if (u.isPresent()) {
			ue = u.get();
			if (ue.getPassword().equals(authRequest.getPassword())) {
				User u1 = new User();
				BeanUtils.copyProperties(ue, u1);
				return u1;
			}
		}
		return null;
	}

	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		List<UserEntity> users = userRepo.findAll();
		List<User> u=new ArrayList<>();
		User us=new User();
		for(UserEntity i:users)
		{
			BeanUtils.copyProperties(i, us);
			u.add(us);
			
			
		}
		return u;
	}

}
