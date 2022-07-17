package com.lg.user.services;


import java.util.List;

import com.lg.user.model.AuthRequest;
import com.lg.user.model.User;

public interface UserService {
	User createUser(User user);
	User updateUser(String username, User user);
	User login(AuthRequest authRequest);
	List<User> getUsers();
}
