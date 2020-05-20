package com.enviyo.drug.service;

import java.util.List;

import com.enviyo.drug.model.User;

public interface UserService {

	User saveUser(User user);

	void deleteUser(String id);

	List<User> getUser();

	User login(User user);
}
