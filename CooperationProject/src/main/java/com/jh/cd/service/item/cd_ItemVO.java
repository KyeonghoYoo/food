package com.jh.cd.service.item;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class cd_ItemVO {
	private String id;
	private int firstCategory_ID;//1차 카테고리 아이디
	private int secondCategory_ID;//2차 카테고리 아이디
	private int thirdCategory_ID; //3차 카테고리 아이디
	private String state;
	private String scode;
	private String itemName;
	private String manufacturer;
	private String origin;
	private String spec;
	private String unit;
	private int price1;
	private int price2;
	private int price3;
	private int purchasePrice;
	private String wareHouseID;
	private int itemQty;
	private String mainProvier;
	private String mainProviderTel;
	private String memo;
	private String remark1;
	private String remark2;

}
