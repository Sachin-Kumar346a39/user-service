package com.cts.user.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.cts.user.model.User;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserRepositoryTest {

	@Autowired
	private UserRepository userRepository;

	private User user;
	private User inValiduser;

	private User expectedUser;

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
		userRepository.save(expectedUser);

	}

	@Test
	void testValidUser() {
		Optional<User> dbUser = userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());

		assertThat(dbUser.isPresent());
		assertEquals(dbUser.get().getUsername(), expectedUser.getUsername());
		assertEquals(dbUser.get().getPassword(), expectedUser.getPassword());
		assertEquals(dbUser.get().isAdmin(), expectedUser.isAdmin());
	}

	@Test
	void testInvalidUser() {
		Optional<User> dbUser = userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());

		assertThat(dbUser.isEmpty());

	}

}
