package com.jh.pm.item;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter @Getter @ToString
public class PmItemVO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;//상품 코드
	private int firstCategory_ID;//1차 카테고리 아이디
	private int secondCategory_ID;//2차 카테고리 아이디
	private int thirdCategory_ID; //3차 카테고리 아이디
	private String state;// 상태
	private String scode;// 표준상품코드
	private String itemName;// 아이템이름
	private String manufacturer;// 제조사
	private String origin;//원산지
	private String spec;//판매규격
	private String unit;//판매단위
	private String price1;//배송단가
	private String price2;
	private String price3;
	private String purchasePrice;
	private String warehouseID;
	private String itemQTY;
	private String mainProvier;
	private String mainProviderTel;
	private String memo;
	private String remark1;
	private String remark2;
	
	@JsonIgnore
	private int offset;
	@JsonIgnore
	private int limit;
	@JsonIgnore
	private String sort;
	@JsonIgnore
	private String orderBy;
	@JsonIgnore
	private MultipartFile itemImage;
}
