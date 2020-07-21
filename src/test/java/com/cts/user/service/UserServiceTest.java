package com.cts.user.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.cts.user.exception.NoResourceException;
import com.cts.user.model.User;
import com.cts.user.repository.UserRepository;

public class UserServiceTest {

	@Mock
	private UserRepository userRepository;

	private User user;
	private User inValiduser;
	private User expectedUser;
	private User dbUser = new User();

	@InjectMocks
	private UserService userService;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);

		user = new User();
		user.setUsername("user@sw.com");
		user.setPassword("pass");

		inValiduser = new User();
		inValiduser.setUsername("user123@sw.com");
		inValiduser.setPassword("pass");

		expectedUser = new User();
		expectedUser.setUsername("user@sw.com");
		expectedUser.setPassword("pass");
		expectedUser.setAdmin(false);

	}

	@Test
	void testValidUser() throws Exception {

		when(userRepository.findByUsernameAndPassword((String) any(), (String) any()))
				.thenReturn(Optional.of(expectedUser));
		dbUser = userService.validateUser(user);
		Assertions.assertEquals(expectedUser.getUsername(), dbUser.getUsername());
		Assertions.assertEquals(expectedUser.getPassword(), dbUser.getPassword());
		Assertions.assertEquals(expectedUser.isAdmin(), dbUser.isAdmin());

	}

	@Test
	void testInvalidUser() throws Exception {

		when(userRepository.findByUsernameAndPassword((String) any(), (String) any())).thenReturn(Optional.empty());
		try {
			userService.validateUser(inValiduser);
		} catch (NoResourceException e) {
			assertEquals("User Not found with Username: user123@sw.com", e.getMessage());
		}
	}

}
