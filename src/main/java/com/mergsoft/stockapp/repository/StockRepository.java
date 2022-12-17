package com.mergsoft.stockapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mergsoft.stockapp.entity.Stock;

public interface StockRepository extends JpaRepository<Stock, Integer> {

	@Query(value="select * from Stock s where s.stockId=?1", nativeQuery = true)
	List<Stock> findByStockId(Integer stockId);

	@Query(value="select * from Stock s ", nativeQuery = true)
	List<Stock> liststock();

}
