package com.enviyo.drug.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.enviyo.drug.model.User;
import com.enviyo.drug.service.UserService;

@CrossOrigin
@RestController
public class UserController {
	@Autowired
	UserService userService;

	@GetMapping("getUser")
	public List<User> getUser() {
		return userService.getUser();
	}

	@PostMapping(path = "/saveUser")
	public User saveUser(@RequestBody User user) {
		return userService.saveUser(user);
	}

	@PostMapping("/deleteUser/{id}")
	public void deleteUser(@PathVariable String id) {
		userService.deleteUser(id);
	}

}
