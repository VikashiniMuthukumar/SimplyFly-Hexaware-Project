package com.hexaware.simplyfly.services;

import java.util.List;

import com.hexaware.simplyfly.entities.User;

public interface IUserService {
	
	User registerUser(User user);
    User loginUser(String email, String password);
    User getUserById(Long userId);
    List<User> getAllUsers();
    void deleteUser(Long userId);
    User updateUser(Long userId, User user);
}
