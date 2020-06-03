package com.jh.pm.category;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter @Getter @ToString
public class SelectCategory {
	List<FirstCategoryVO> firstCategoryVOs;
	List<SecondCategoryVO> secondCategoryVOs;
	List<ThirdCategoryVO> thirdCategoryVOs;
}
