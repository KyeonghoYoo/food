package com.jh.cd.service.orderitem;

public class cd_OrderItemVO {
	private String id;
	private String tbOrder_Id;
	private String tbItem_Id;
	private int price;
	private int qty;
	private String amount;
	private String state;
	private String updateDate;
	private String memo;
	private String remark1;
	private String remark2;
	
	@Override
	public String toString() {
		return "OrderItemVO [id=" + id + ", tbOrder_Id=" + tbOrder_Id + ", tbItem_Id=" + tbItem_Id + ", price=" + price
				+ ", qty=" + qty + ", amount=" + amount + ", state=" + state + ", updateDate=" + updateDate + ", memo="
				+ memo + ", remark1=" + remark1 + ", remark2=" + remark2 + "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTbOrder_Id() {
		return tbOrder_Id;
	}
	public void setTbOrder_Id(String tbOrder_Id) {
		this.tbOrder_Id = tbOrder_Id;
	}
	public String getTbItem_Id() {
		return tbItem_Id;
	}
	public void setTbItem_Id(String tbItem_Id) {
		this.tbItem_Id = tbItem_Id;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public String getRemark1() {
		return remark1;
	}
	public void setRemark1(String remark1) {
		this.remark1 = remark1;
	}
	public String getRemark2() {
		return remark2;
	}
	public void setRemark2(String remark2) {
		this.remark2 = remark2;
	}

}
