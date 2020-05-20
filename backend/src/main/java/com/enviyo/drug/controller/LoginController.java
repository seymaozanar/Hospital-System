package com.enviyo.drug.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.enviyo.drug.model.User;
import com.enviyo.drug.service.UserService;
@CrossOrigin
@RestController
public class LoginController {
	@Autowired
	private UserService userService;

	@PostMapping(name="/loginYap")
	public User login(@RequestBody User user) {
		return userService.login(user);
	}

}