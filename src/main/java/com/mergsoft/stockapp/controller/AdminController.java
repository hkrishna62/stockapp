package com.mergsoft.stockapp.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.mergsoft.stockapp.entity.User;
import com.mergsoft.stockapp.service.AdminService;
import com.mergsoft.stockapp.service.UserService;

@Controller
public class AdminController {
	
	Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	// @Autowired
	private AdminService adminService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/getcreateuserform/{adminid}")
	public String getcreateUserForm(@PathVariable("adminid") Integer userId, User user, Model model) {
		
		System.out.println("***  "+userId);
		model.addAttribute("adminid", userId );
		
		return "createuser";
		 
	}
	
	
	
	@PostMapping("/createuser")
	public String createUser(@ModelAttribute("user") User user, Model model) {
		
		logger.info(" user details ::  "+user.getUserId());
		
		Integer userId=user.getUserId();
		
	List<User> userlist=	userService.findUser(userId);
	
	logger.info(" user list ::  "+userlist.size());
	 
	 if(userlist.size() == 0) {
		 logger.info(" user not exist userId "+userId);
		 user=	userService.createUser(user);
		 
		 return "index";
		 
		 
	 }else {
		 
		 model.addAttribute("userid1", userId );
		 model.addAttribute("errmsg1", "user already exist");
		 logger.info(" user already exist userId "+userId);
		 return "createuser";
		 
	 }
		
		
	}
	
	
	
	

}
