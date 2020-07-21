package com.cts.user.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.user.exception.NoResourceException;
import com.cts.user.model.User;
import com.cts.user.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRespository;

	public User validateUser(User user) {
		
		Optional<User> dbUser = userRespository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
		
		return dbUser.orElseThrow(() -> new NoResourceException("User", "Username", user.getUsername()));

	}

}
