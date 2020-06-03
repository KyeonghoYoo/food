package com.jh.pm.purchase;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jh.pm.purchaseitem.PmPurchaseItemJoinItemVO;
import com.jh.pm.purchaseitem.PmPurchaseItemVO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class PmPurchaseVO {

	private String id;
	private Date regDate;
	private String remark;
	private String tbProvider_ID;
	private Date dDay;
	private String state; // 발주 대기, 발주 완료, 출고 대기, 출고 완료, 입고대기, 입고완료
	private String bName;
	
	private List<PmPurchaseItemVO> pmPurchaseItemVOs;
	
	private List<PmPurchaseItemJoinItemVO> pmPurchaseItemJoinItemVOs;
	
	@JsonIgnore
	private int offset;
	@JsonIgnore
	private int limit;
	@JsonIgnore
	private String sort;
	@JsonIgnore
	private String purchaseBy;
	
	@JsonIgnore
	private String purchaseStartDate;
	@JsonIgnore
	private String purchaseEndDate;
	@JsonIgnore
	private String reqStartDate;
	@JsonIgnore
	private String reqEndDate;
}