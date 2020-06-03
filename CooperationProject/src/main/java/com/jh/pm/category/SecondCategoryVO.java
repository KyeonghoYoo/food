package com.jh.pm.category;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter @Getter @ToString
public class SecondCategoryVO {
	private int firstCategoryID;
	private int secondCategoryID;
	private String secondCategoryCode;
	private String secondCategoryName;
	private String secondCategoryMemo;
	private String secondCategoryRemark;
	private int secondCategorySequence;
	@JsonIgnore
	private int secondCategoryNum;
}
