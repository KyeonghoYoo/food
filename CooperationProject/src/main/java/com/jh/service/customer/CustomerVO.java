package com.jh.service.customer;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class CustomerVO {
	private String id;
	private Date regdate;
	private String userid;
	private String userpw;
	private String bname;
	private String bnumber;
	private String bsector;
	private String chief;
	private String manager;
	private String tel;
	private String fax;
	private String mobile;
	private String postno;
	private String address1;
	private String address2;
	private String address3;
	private String location;
	private int pricerate;
	private int creditlimit;
	private int points;
	private String delrivererid;
	private String salesmanid;
	private String memo;
	private String remark1;
	private String remark2;
	private boolean isauth;
}
