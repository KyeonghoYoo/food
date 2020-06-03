package com.jh.pm.item;

import com.jh.pm.category.FirstCategoryVO;
import com.jh.pm.category.SecondCategoryVO;
import com.jh.pm.category.ThirdCategoryVO;

import lombok.Data;

@Data
public class PmSelectOneItemVO {
	private PmItemVO itemVO;
	private FirstCategoryVO firstCategoryVO;
	private SecondCategoryVO secondCategoryVO;
	private ThirdCategoryVO thirdCategoryVO;
}
