package com.jh.pm.purchaseitem;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter @Getter @ToString
public class PmPurchaseItemVO {
	private String id;
	private String purchaseDate;
	private String tbItem_ID;
	private String tbProvider_ID;
	private int price;
	private int qty;
	private int amount;
	private String state;
	private Date updateDate;
	private String Memo;
	private String Remark1;
	private String Remark2;
	private String tbPurchase_ID;
}
