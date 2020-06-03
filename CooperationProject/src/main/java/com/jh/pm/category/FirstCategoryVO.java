package com.jh.pm.category;


import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter @Getter @ToString
public class FirstCategoryVO {
	private int firstCategoryID;
	private String firstCategoryCode;
	private String firstCategoryName;
	private String firstCategoryMemo;
	private String firstCategoryRemark;
	private int firstCategorySequence;
	
	@JsonIgnore
	private int firstCategoryNum;
}
