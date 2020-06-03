package com.jh.pm.member;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class PmMemberVO {
	private String id;
	private String userID;
	private String userPW;
	private String name;
	private String role;
	private String itemAccess;
	private String customerAccess;
	private String providerAccess;
	private String delivererAcces;
	private String orderAccess;
	private String purchaseAccess;
	private String noticeAccess;
	private String paymentAccess;
	private String remark1;
	private String remark2;
	private String remark3;
	private String remark4;
	private String remark5;
	private String memo;
}
