package com.mergsoft.stockapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mergsoft.stockapp.entity.User;
import com.mergsoft.stockapp.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User getUserAccountType(Integer userId) {
		
		return userRepository.getUserByUserId(userId);
	}

	@Override
	public List<User> loginCheck(Integer userId, String password) {
		
		return userRepository.loginCheck(userId, password);
	}

	@Override
	public List<User> findUser(Integer userId) {
		
		return userRepository.findUser(userId);
	}

	@Override
	public User createUser(User user) {
		
		return userRepository.save(user);
	}

	
}
