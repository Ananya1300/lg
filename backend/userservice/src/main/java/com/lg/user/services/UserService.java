package com.lg.user.services;


import java.util.List;

import com.lg.user.dto.AuthRequest;
import com.lg.user.model.User;

public interface UserService {
	User login(AuthRequest authRequest);
	List<User> getUsers();
	User createUser(User user);
}
