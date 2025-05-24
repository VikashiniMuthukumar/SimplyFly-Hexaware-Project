package com.hexaware.simplyfly.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.simplyfly.entities.User;
import com.hexaware.simplyfly.repositories.UserRepository;

@Service
public class UserServiceImpl implements IUserService{

	@Autowired
	UserRepository repo;
	
	@Override
	public User registerUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User loginUser(String email, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserById(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUser(Long userId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User updateUser(Long userId, User user) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
