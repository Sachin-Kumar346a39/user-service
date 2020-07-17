package com.cts.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.user.exception.NoResourceException;
import com.cts.user.model.User;
import com.cts.user.service.UserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/api/v1/user")
@CrossOrigin(origins = "*")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/validateUser")
	public ResponseEntity<User> validateUser(@Valid @RequestBody User user) {
		HttpStatus status = HttpStatus.OK;
		User userResult = null;
		try {

			userResult = userService.validateUser(user);

		} catch (NoResourceException ex) {
			log.error("User Controller Exception: ", ex.getMessage());
			status = HttpStatus.NOT_FOUND;
		}
		return new ResponseEntity<User>(userResult, status);
	}
	
	@PostMapping("/logout")
	public boolean destroySession(HttpServletRequest request) {
		request.getSession().invalidate();
		return true;
	}
}
