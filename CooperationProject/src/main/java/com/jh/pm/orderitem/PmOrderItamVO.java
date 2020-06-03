package com.jh.pm.orderitem;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter @Getter @ToString
public class PmOrderItamVO {
	private String id;
	private String tbOrder_ID;
	private String tbitem_ID;
	private int price;
	private int qty;
	private int amount;
	private String state;
	private Date updateDate;
	private String memo;
	private String remark1;
	private String remark2;
}
