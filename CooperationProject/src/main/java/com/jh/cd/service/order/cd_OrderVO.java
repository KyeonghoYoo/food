package com.jh.cd.service.order;

public class cd_OrderVO {
	private String id;
	private String tbcustomer_id;
	private String orderdate;
	private int itemcount;
	private int amount;
	private int points;
	private int payment;
	private String paymethod;
	private String reqdate;
	private String requests;
	private String tbdeliverer_id;
	private String salespersonid;
	private String orderstate;
	private String updatedate;
	private String address1;
	private String address2;
	private String address3;
	private String memo;
	private String remark1;
	private String remark2;
	public String getReqdate() {
		return reqdate;
	}

	public void setReqdate(String reqdate) {
		this.reqdate = reqdate;
	}

	public String getCustomerBname() {
		return customerBname;
	}

	public void setCustomerBname(String customerBname) {
		this.customerBname = customerBname;
	}

	private String customerBname;

	public String getPaymethod() {
		return paymethod;
	}

	public void setPaymethod(String paymethod) {
		this.paymethod = paymethod;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTbcustomer_id() {
		return tbcustomer_id;
	}

	public void setTbcustomer_id(String tbcustomer_id) {
		this.tbcustomer_id = tbcustomer_id;
	}

	public String getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(String orderdate) {
		this.orderdate = orderdate;
	}

	public int getItemcount() {
		return itemcount;
	}

	public void setItemcount(int itemcount) {
		this.itemcount = itemcount;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public int getPayment() {
		return payment;
	}

	public void setPayment(int payment) {
		this.payment = payment;
	}

	public String getRegdate() {
		return reqdate;
	}

	public void setRegdate(String regdate) {
		this.reqdate = regdate;
	}

	public String getRequests() {
		return requests;
	}

	public void setRequests(String requests) {
		this.requests = requests;
	}

	public String getTbdeliverer_id() {
		return tbdeliverer_id;
	}

	public void setTbdeliverer_id(String tbdeliverer_id) {
		this.tbdeliverer_id = tbdeliverer_id;
	}

	public String getSalespersonid() {
		return salespersonid;
	}

	public void setSalespersonid(String salespersonid) {
		this.salespersonid = salespersonid;
	}

	public String getOrderstate() {
		return orderstate;
	}

	public void setOrderstate(String orderstate) {
		this.orderstate = orderstate;
	}

	public String getUpdatedate() {
		return updatedate;
	}

	public void setUpdatedate(String updatedate) {
		this.updatedate = updatedate;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getAddress3() {
		return address3;
	}

	public void setAddress3(String address3) {
		this.address3 = address3;
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

	@Override
	public String toString() {
		return "OrderVO [id=" + id + ", tbcustomer_id=" + tbcustomer_id + ", orderdate=" + orderdate + ", itemcount="
				+ itemcount + ", amount=" + amount + ", points=" + points + ", payment=" + payment + ", regdate="
				+ reqdate + ", requests=" + requests + ", tbdeliverer_id=" + tbdeliverer_id + ", salespersonid="
				+ salespersonid + ", orderstate=" + orderstate + ", updatedate=" + updatedate + ", address1=" + address1
				+ ", address2=" + address2 + ", address3=" + address3 + ", memo=" + memo + ", remark1=" + remark1
				+ ", remark2=" + remark2 + "]";
	}
}
