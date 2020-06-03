package com.jh.cd.service.adboard;

public class cd_ADBoardVO {
	private String id;
	private String regDate;
	private String updateDate;
	private String startDate;
	private String endDate;
	private String title;
	private String imgURL;
	private String remark1;
	private String remark2;

	
	@Override
	public String toString() {
		return "ADBoardVO [id=" + id + ", regDate=" + regDate + ", updateDate=" + updateDate + ", startDate="
				+ startDate + ", endDate=" + endDate + ", title=" + title + ", imgURL=" + imgURL + ", remark1="
				+ remark1 + ", remark2=" + remark2 + "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public String getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImgURL() {
		return imgURL;
	}
	public void setImgURL(String imgURL) {
		this.imgURL = imgURL;
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
