package com.mergsoft.stockapp.service;

import java.util.List;

import com.mergsoft.stockapp.entity.User;

public interface UserService {

	
	User getUserAccountType(Integer userId);

	List<User> loginCheck(Integer userId, String password);

}
