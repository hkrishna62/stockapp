package com.mergsoft.stockapp.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mergsoft.stockapp.entity.Stock;

public interface StockService {

	List<Stock> findStock(Integer stockId);

	Stock createStock(Stock stock);

	List<Stock> listStock();

	Page<Stock> getAllStock(Pageable pageable);

}
