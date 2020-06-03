package com.jh.cd.service.customeritem;

import java.sql.Date;

public class cd_CustomerItemVO {
	private String id;
	private String tbCustomer_ID;
	private String tbItem_ID;
	private Date regDate;
	private String memo;
	private String remark1;
	private String remark2;
	
	@Override
	public String toString() {
		return "CustomerItemVO [id=" + id + ", tbCustomer_ID=" + tbCustomer_ID + ", tbItem_ID=" + tbItem_ID
				+ ", regDate=" + regDate + ", memo=" + memo + ", remark1=" + remark1 + ", remark2=" + remark2 + "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTbCustomer_ID() {
		return tbCustomer_ID;
	}
	public void setTbCustomer_ID(String tbCustomer_ID) {
		this.tbCustomer_ID = tbCustomer_ID;
	}
	public String getTbItem_ID() {
		return tbItem_ID;
	}
	public void setTbItem_ID(String tbItem_ID) {
		this.tbItem_ID = tbItem_ID;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
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
