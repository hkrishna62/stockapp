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
@Table(name="stock")
public class Stock {
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private Integer id;
	
	@Id
	@Column(name="stockid")
	private Integer stockId;
	
	@Column(name="companyname")
	private String companyName;
	
	@Column(name="stocksymbol")
	private String stockSymbol;
	
	@Column(name="unitprice")
	private Double unitPrice;
	
	@Column(name="unitsavailable")
	private Integer unitsAvailable;
	
	@Column(name="unitsold")
	private Integer unitSold;
	
	@Column(name="totalunits")
	private Integer totalUnits;
	
	

}
