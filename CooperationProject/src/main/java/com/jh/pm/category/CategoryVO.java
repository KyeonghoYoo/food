package com.jh.pm.category;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter @Getter @ToString
public class CategoryVO {
	private Integer parentCategoryId;
	private int categoryID;
	@NotNull
	private int categoriesLevel;
	private String categoryCode;
	@NotNull
	private String categoryName;
	private String categoryMemo;
	private String categoryRemark;
	private int categorySequence;
}