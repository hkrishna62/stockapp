package com.mergsoft.stockapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.mergsoft.stockapp.entity.User;
import com.mergsoft.stockapp.service.AdminService;

@Controller
public class AdminController {
	
	// @Autowired
	private AdminService adminService;
	
	@GetMapping("/getcreateuserform")
	public String getcreateUserForm(@ModelAttribute("user") User user, Model model) {
		
		System.out.println(""+user.getUserId());
		return "admin";
		
	}
	

}
