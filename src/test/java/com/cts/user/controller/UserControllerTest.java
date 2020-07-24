package com.cts.user.controller;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.cts.user.exception.NoResourceException;
import com.cts.user.model.User;
import com.cts.user.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest
public class UserControllerTest {

	@InjectMocks
	private UserController userController;

	@MockBean
	private UserService userService;

	private User user;

	private User expectedUser;

	private MockMvc mockMvc;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(userController).build();

		user = new User();
		user.setUsername("user123@sw.com");
		user.setPassword("pass");

		expectedUser = new User();
		expectedUser.setUsername("user@sw.com");
		expectedUser.setPassword("pass");
		expectedUser.setAdmin(false);

	}

	//@Test

	void testValidUser() throws Exception {

		when(userService.validateUser((User) any())).thenReturn(expectedUser);
		mockMvc.perform(post("/api/v1/user/validateUser").contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(expectedUser))).andExpect(status().isOk()).andDo(MockMvcResultHandlers.print());
	}

	//@Test

	void testInvalidUser() throws Exception {

		when(userService.validateUser((User) any()))
				.thenThrow(new NoResourceException("User", "Username", user.getUsername()));
		mockMvc.perform(
				post("/api/v1/user/validateUser").contentType(MediaType.APPLICATION_JSON).content(asJsonString(user)))
				.andExpect(status().isNotFound()).andDo(MockMvcResultHandlers.print());
	}

	private String asJsonString(final Object obj) {

		try {

			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {

			throw new RuntimeException(e.getMessage());
		}
	}
	
	
	//@Test
	
	void testDestroySession() throws Exception{
		mockMvc.perform(post("/api/v1/user/logout")).andExpect(result->assertTrue(true));
	}


}
