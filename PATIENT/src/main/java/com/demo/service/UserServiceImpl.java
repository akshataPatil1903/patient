package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.model.User;
import com.demo.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository ur;
	
	
	@Override
	public void addUser(User u) {
		// TODO Auto-generated method stub
		ur.save(u);
		
	}

	@Override
	public List<User> displayUser() {
		// TODO Auto-generated method stub
		return ur.findAll();
	}

	@Override
	public User updateUser(Integer id, User u) {
		// TODO Auto-generated method stub
		u.setId(id);
		return ur.save(u);
	}

	@Override
	public void deleteUser(Integer id) {
		// TODO Auto-generated method stub
		ur.deleteById(id);
	}

}
