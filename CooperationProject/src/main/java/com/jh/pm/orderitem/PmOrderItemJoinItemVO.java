package com.jh.pm.orderitem;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter @Getter @ToString
public class PmOrderItemJoinItemVO {
	private String tbOrderItemID;
	private String tbOrderItemTbOrder_ID;
	private String tbOrderItemTbItem_ID;
	private String tbOrderItemPrice;
	private String tbOrderItemQTY;
	private String tbOrderItemAmount;
	private String tbOrderItemState;
	private String tbOrderItemUpdateDate;
	private String tbOrderItemMemo;
	private String tbOrderItemRemark1;
	private String tbOrderItemRemark2;
	private String tbItemID;
	private String tbItemFirstCategory_ID;
	private String tbItemSecondCategory_ID;
	private String tbItemThirdCategory_ID;
	private String tbItemState;
	private String tbItemScode;
	private String tbItemItemName;
	private String tbItemManufacturer;
	private String tbItemOrigin;
	private String tbItemSpec;
	private String tbItemUnit;
	private String tbItemPrice1;
	private String tbItemPrice2;
	private String tbItemPrice3;
	private String tbItemPurchasePrice;
	private String tbItemWarehouseID;
	private String tbItemItemQTY;
	private String tbItemMainProvier;
	private String tbItemMainProviderTel;
	private String tbItemMemo;
	private String tbItemRemark1;
	private String tbItemRemark2;
}
