package com.mergsoft.stockapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="buystock")
public class BuyStock {
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private Integer id;
	
	@Id
	@Column(name="userid")
	private Integer userId;
	
	@Column(name="stockid")
	private Integer stockId;
	
	@Column(name="companyname")
	private String companyName;
	
	@Column(name="stocksymbol")
	private String stockSymbol;
	
	@Column(name="unitprice")
	private Double unitPrice;
	
	
	@Column(name="noofunits")
	private Integer noofUnits;
	

}
