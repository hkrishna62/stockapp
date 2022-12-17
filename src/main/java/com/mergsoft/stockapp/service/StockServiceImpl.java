package com.mergsoft.stockapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mergsoft.stockapp.entity.Stock;
import com.mergsoft.stockapp.repository.StockRepository;

@Service
public class StockServiceImpl implements StockService {
	
	@Autowired
	StockRepository stockRepo;

	@Override
	public List<Stock> findStock(Integer stockId) {
		
		return stockRepo.findByStockId(stockId);
	}

	@Override
	public Stock createStock(Stock stock) {
		
		return stockRepo.save(stock);
	}

	@Override
	public List<Stock> listStock() {
		
		return stockRepo.liststock();
	}

	@Override
	public Page<Stock> getAllStock(Pageable pageable) {
		
		return stockRepo.findAll(pageable);
	}

}
