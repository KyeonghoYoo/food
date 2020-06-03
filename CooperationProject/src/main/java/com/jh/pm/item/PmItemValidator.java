package com.jh.pm.item;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import com.jh.common.StaicKeyWord;
import com.jh.pm.category.CategoryDAO;
import com.jh.pm.category.CategoryVO;

@Component
public class PmItemValidator {
	
	@Autowired CategoryDAO categoryDAO;
	@Autowired PmItemDAO itemDAO;
	CategoryVO categoryVO;
	String[] sorts = { "state", "itemName", "manufacturer", "origin", "spec", "unit", "price1", "price2", "price3",
			"purchasePrice", "itemQTY" };

	public void insertAndUpateItemValidator(PmItemVO itemVO, Errors errors) {
		// 등록할 카테고리가 존재하는 지
		// 1차 카테고리 정보 조회
		if (itemVO.getFirstCategory_ID() != 0) {
			CategoryVO categoryVO = new CategoryVO();
			categoryVO.setCategoryID(itemVO.getFirstCategory_ID());
			categoryVO.setCategoriesLevel(StaicKeyWord.FIRST);
			if (categoryDAO.getFirstCategory(categoryVO).isEmpty()) {
				errors.reject("firstCategory_ID", "no prime key");
			}
		}
		// 2차 카테고리 정보 조회
		if (itemVO.getSecondCategory_ID() != 0) {
			CategoryVO categoryVO = new CategoryVO();
			categoryVO.setCategoryID(itemVO.getSecondCategory_ID());
			categoryVO.setCategoriesLevel(StaicKeyWord.SECOND);
			if (categoryDAO.getSecondCategory(categoryVO).isEmpty()) {
				errors.reject("secondCategory_ID", "no prime key");
			}
		}

		// 3차 카테고리 정보 조회
		if (itemVO.getThirdCategory_ID() != 0) {
			CategoryVO categoryVO = new CategoryVO();
			categoryVO.setCategoryID(itemVO.getThirdCategory_ID());
			categoryVO.setCategoriesLevel(StaicKeyWord.THIRD);
			if (categoryDAO.getThirdCategory(categoryVO).isEmpty()) {
				errors.reject("thirdCategory_ID", "no prime key");
			}
		}
		// 등록할 창고가 존재하는 지

		// 등록할 주 공급자가 존재하는 지
	}

	public void selectListItemValidator(PmItemVO itemVO, Errors errors) {

		// Limit 값이 없으면 default = 10
		if (itemVO.getLimit() == 0)
			itemVO.setLimit(10);

		String orderBy = itemVO.getOrderBy();
		// 아이템 정렬 방법, 정렬 속성명이 존재하는지
		if (itemVO.getOrderBy() != null || itemVO.getSort() != null) {
			if (!(orderBy != null && itemVO.getSort() != null)) {
				errors.reject("orderBy or sort", "is null");
			}else if (orderBy != null) {
				orderBy = orderBy.toLowerCase();
				if (orderBy != "asc" && orderBy != "desc") {
					errors.reject("fild orderBy", "is wrong.");	
				}
			}
			// 정렬 속성명이 맞는지
			if (!useArraysBinarySearch(sorts, itemVO.getSort())) {
				errors.reject("fild sort", "is wrong.");
			}
		}

	}
	
	public PmItemVO selectOneItemValidator(String id, Errors errors) {
		PmItemVO itemVO = itemDAO.selectOneItem(id);
		if (itemVO == null) {
			errors.reject("id","no prime key");
		}
		return itemVO;
	}
	public static boolean useArraysBinarySearch(String[] arr, String targetValue) {
		return Arrays.binarySearch(arr, targetValue) > 0 ? true: false;
	}
}
