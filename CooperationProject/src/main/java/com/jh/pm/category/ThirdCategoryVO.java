package com.jh.pm.category;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter @Getter @ToString
public class ThirdCategoryVO {
	private int secondCategoryID;
	private int thirdCategoryID;
	private String thirdCategoryCode;
	private String thirdCategoryName;
	private String thirdCategoryMemo;
	private String thirdCategoryRemark;
	private int thirdCategorySequence;
	@JsonIgnore
	private int thirdCategorNum;
}
