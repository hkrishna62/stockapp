package com.mergsoft.stockapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class IndexPageController {
	 
	
	@GetMapping("/getindex")
	public String getHomePage() {
		
		return "index";
	}
	
	
	
	@GetMapping("/getcontact")
	public String getContactPage() {
		
		return "contact1";
	}
	
	@GetMapping("/getcontact1")
	public String getContactPage1() {
		
		return "contact1";
	}
	
	
	@PostMapping("/sendmessage1")
	public String sendMessage1() {
		
		return "index";
	}
	
	

}
