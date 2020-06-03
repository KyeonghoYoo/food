package com.jh.pm.ads;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class AdVO {
	private int  adID;
	private String  adCode;
	private Date  adRegDate;
	private Date adUpdateDate;
	private Date  adStartDate;
	private Date  adEndDate;
	private String adRegDateString;
	private String adUpdateDateString;
	@NotNull
	private String  adStartDateString;
	@NotNull
	private String  adEndDateString;
	@NotNull
	private String  adTitle;
	private String  adImgURL;
	private String  adMemo;
	private String  adRemark1;
	private MultipartFile  adImage;
	
	Date date = new Date();
	
	public void update() {
		adRegDate = adUpdateDate = date;
	}
}
