package com.jh.pm.order;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jh.pm.orderitem.PmOrderItamVO;
import com.jh.pm.orderitem.PmOrderItemJoinItemVO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class PmOrderVO {
	private String id;
	private String tbCustomer_ID;
	private Date orderDate;
	private int itemCount;
	private int amount;
	private int points;
	private int payment;
	private String payMethod;
	private Date reqDate;
	private String requests;
	private String tbDeliverer_ID;
	private String orderState;
	private Date updateDate;
	private String address1;
	private String address2;
	private String address3;
	private String memo;
	private String remark1;
	private String remark2;
	private String salesPersonID;
	
	private List<PmOrderItamVO> pmOrderItamVOs;
	
	private List<PmOrderItemJoinItemVO> pmOrderItemJoinItemVOs;
	
	@JsonIgnore
	private int offset;
	@JsonIgnore
	private int limit;
	@JsonIgnore
	private String sort;
	@JsonIgnore
	private String orderBy;
	
	@JsonIgnore
	private String orderStartDate;
	@JsonIgnore
	private String orderEndDate;
	@JsonIgnore
	private String reqStartDate;
	@JsonIgnore
	private String reqEndDate;
}