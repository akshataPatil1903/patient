package com.demo.service;

import java.util.List;

import com.demo.model.User;

public interface UserService {

	void addUser(User u);

	List<User> displayUser();

	User updateUser(Integer id, User u);

	void deleteUser(Integer id);

}
