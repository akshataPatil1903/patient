package com.demo.controller;

import java.util.List;

import org.hibernate.query.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.User;
import com.demo.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService us;

	@PostMapping("addUser")
	public void addUser(@RequestBody User u) {
		us.addUser(u);
	}

	@GetMapping("displayUser")
	public List<User> displayUser() {
		return us.displayUser();
	}

	@PutMapping("updateUser = {id}")
	public User updateUser(@PathVariable Integer id, @RequestBody User u) {
		return us.updateUser(id, u);
	}

	@DeleteMapping("deleteUser = {id}")
	public void deleteUser(@PathVariable Integer id) {
		us.deleteUser(id);

	}

}
