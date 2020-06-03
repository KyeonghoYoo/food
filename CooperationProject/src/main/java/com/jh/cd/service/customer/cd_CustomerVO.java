package com.jh.cd.service.customer;

import java.sql.Date;

public class cd_CustomerVO {
	private String id;
	private Date regdate;
	private String userid;
	private String userpw;
	private String bname;
	private String bnumber;
	private String bsector;
	private String chief;
	private String manager;
	private String tel;
	private String fax;
	private String mobile;
	private String postno;
	private String address1;
	private String address2;
	private String address3;
	private String location;
	private int pricerate;
	private int creditlimit;
	private int points;
	private String tbDeliverer_ID;
	private String salesman_ID;
	private String memo;
	private String remark1;
	private String remark2;
	@Override
	public String toString() {
		return "CustomerVO [id=" + id + ", regdate=" + regdate + ", userid=" + userid + ", userpw=" + userpw
				+ ", bname=" + bname + ", bnumber=" + bnumber + ", bsector=" + bsector + ", chief=" + chief
				+ ", manager=" + manager + ", tel=" + tel + ", fax=" + fax + ", mobile=" + mobile + ", postno=" + postno
				+ ", address1=" + address1 + ", address2=" + address2 + ", address3=" + address3 + ", location="
				+ location + ", pricerate=" + pricerate + ", creditlimit=" + creditlimit + ", points=" + points
				+ ", tbDeliverer_ID=" + tbDeliverer_ID + ", salesman_ID=" + salesman_ID + ", memo=" + memo
				+ ", remark1=" + remark1 + ", remark2=" + remark2 + "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUserpw() {
		return userpw;
	}
	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getBnumber() {
		return bnumber;
	}
	public void setBnumber(String bnumber) {
		this.bnumber = bnumber;
	}
	public String getBsector() {
		return bsector;
	}
	public void setBsector(String bsector) {
		this.bsector = bsector;
	}
	public String getChief() {
		return chief;
	}
	public void setChief(String chief) {
		this.chief = chief;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getPostno() {
		return postno;
	}
	public void setPostno(String postno) {
		this.postno = postno;
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
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getPricerate() {
		return pricerate;
	}
	public void setPricerate(int pricerate) {
		this.pricerate = pricerate;
	}
	public int getCreditlimit() {
		return creditlimit;
	}
	public void setCreditlimit(int creditlimit) {
		this.creditlimit = creditlimit;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	public String getTbDeliverer_ID() {
		return tbDeliverer_ID;
	}
	public void setTbDeliverer_ID(String tbDeliverer_ID) {
		this.tbDeliverer_ID = tbDeliverer_ID;
	}
	public String getSalesman_ID() {
		return salesman_ID;
	}
	public void setSalesman_ID(String salesman_ID) {
		this.salesman_ID = salesman_ID;
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
