package com.mergsoft.stockapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.mergsoft.stockapp.entity.User;
import com.mergsoft.stockapp.service.AdminService;

@Controller
public class AdminController {
	
	// @Autowired
	private AdminService adminService;
	
	@PostMapping("/createuser")
	public String createUser(@ModelAttribute("user") User user, Model model) {
		
		
		return "admin";
		
	}
	

}
