package com.mergsoft.stockapp.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.mergsoft.stockapp.entity.Stock;
import com.mergsoft.stockapp.service.StockService;

@Controller
public class StockController {
	
	Logger logger=LoggerFactory.getLogger(StockController.class);
	
	@Autowired
	StockService stockService;
	
	@GetMapping("/addstock")
	public String getAddStockPage(@ModelAttribute("stock") Stock stock,  Model model) {
		
		return "addstock";
	}
	
	
	@PostMapping("/createstock")
	public String createStock(@ModelAttribute("stock") Stock stock, Model model) {
		
		logger.info(" stock --  "+stock);
		
		Integer stockId=stock.getStockId();
		
		logger.info(" createstock stockId --  "+stockId);
		
		if(stockId !=null) {
			
		List<Stock> list=stockService.findStock(stockId);
		
		if(list.isEmpty()) {
			stock=	stockService.createStock(stock);
			return "admin";
		}
		
		}
		model.addAttribute("errmsg1", "EmptyStockDetails");
		return "addstock";
		
	}

}
