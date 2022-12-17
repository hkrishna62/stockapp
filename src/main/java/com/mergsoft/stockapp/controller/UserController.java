package com.mergsoft.stockapp.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.mergsoft.stockapp.entity.BuyStock;
import com.mergsoft.stockapp.entity.Stock;
import com.mergsoft.stockapp.entity.User;
import com.mergsoft.stockapp.service.StockService;

@Controller
public class UserController {
	
	Logger log=LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	StockService stockService;
	
	@GetMapping("/userliststock/{userId}")
	public String userListStock(@PathVariable("userId") String userid, User user, Model model,
			@PageableDefault(page = 0,size = 3) Pageable pageable) {
		
		Integer userId=Integer.parseInt(userid);
		
		log.info(" userListStock user id :: "+userId);
		
		model.addAttribute("userid", userId);
		
		List<Stock> stock =stockService.listStock();
		
		log.info(" list stock ::  "+stock);
		
		model.addAttribute("stock", stock);
		
		Page<Stock> page = stockService.getAllStock(pageable);
		
		log.info("page -- "+page);
		
		
		model.addAttribute("list", page.getContent());
		model.addAttribute("pob", page);
		
		
		return "stocklist";
		
	}
	
	@GetMapping("/buystockform")
	public String buystockForm(@ModelAttribute("buystock") BuyStock buystock) {
		
		
		return "buystock";
		
	}
	
	
	
	
	//3. Display data + pagination
		//.... /all?page=2&size=5
		//...../all (defaults)
		@GetMapping("/all")
		public String showPageData(
				@PageableDefault(page = 0,size = 3) Pageable pageable,
				Model model
				) 
		{
			Page<Stock> page = stockService.getAllStock(pageable);
			
			log.info("page -- "+page);
			
			List<Stock> stock =stockService.listStock();
			model.addAttribute("list", page.getContent());
			model.addAttribute("pob", page);
			return "stocklist";
		}

}
