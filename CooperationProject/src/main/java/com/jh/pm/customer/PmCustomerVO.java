package com.jh.pm.customer;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class PmCustomerVO {
	private String id;
	private Date regDate;
	private String userID;
	private String userPW;
	private String bname;
	private String bnumber;
	private String bsector;
	private String chief;
	private String manager;
	private String tel;
	private String fax;
	private String email;
	private String mobile;
	private String postNo;
	private String address1;
	private String address2;
	private String address3;
	private String location;
	private int priceRate;
	private int creditLimit;
	private int points;
	private String tbDeliverer_ID;
	private String salesman_ID;
	private String memo;
	private String remark1;
	private String remark2;
	@JsonIgnore
	private int offset;
	@JsonIgnore
	private int limit;
	@JsonIgnore
	private String sort;
	@JsonIgnore
	private String orderBy;	
	private String allCount;
}
