package com.mergsoft.stockapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="user")
public class User {
	
	@Column(name="id")
	private Integer id;
	
	@Id
	@Column(name="userid")
	private Integer userId;
	
	@Column(name="username")
	private String userName;
	
	@Column(name="email")
	private String email;
	
	@Column(name="phoneno")
	private String phoneNo;
	
	@Column(name="password")
	private String password;
	
	@Column(name="address")
	private String address;
	
	@Column(name="accountstatus")
	private String accountStatus;
	
	@Column(name="accusertype")
	private String accUserType;
	
	@Column(name="pancardno")
	private String panCardNo;
	
	@Column(name="bankaccno")
	private String bankAccNo;
	
	@Column(name="bankaccifsc")
	private String bankAccIFSC;
	
	

}
