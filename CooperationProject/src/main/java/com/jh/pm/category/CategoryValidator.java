package com.jh.pm.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;




@Component
public class CategoryValidator {
	
	@Autowired CategoryDAO categoryDAO;

	
	//삽입 유효성 검사
	public void insertValidate(CategoryVO categoryVO, Errors errors) throws Exception {
		
		int level = categoryVO.getCategoriesLevel();
		if (!levelCheck(level, errors))return;
		
		if(level == 1){
			return;
		}else if ((categoryVO.getParentCategoryId() == null || (categoryVO.getParentCategoryId() == 0) )) {
			errors.reject("categoryCode", "value null");
			return;
		}
		else{
			switch (level) {
			case 2:
				if (categoryDAO.getFirstCategory(categoryVO) == null)
					errors.reject("parentCategoryId", "No data.");
				return;
				
			case 3:
				if (categoryDAO.getSecondCategory(categoryVO) == null) {
					errors.reject("parentCategoryId", "No data.");
				}
				return;
			}
		}
	}

	//수정 유효성 감사
	public void updateValidate(CategoryVO categoryVO, Errors errors) {
		if (!levelCheck(categoryVO.getCategoriesLevel(), errors))return;
		switch (categoryVO.getCategoriesLevel()) {
		case 1:
			if (categoryDAO.getFirstCategory(categoryVO).isEmpty())
				errors.reject("CategoryId", "No data.");
			return;
		case 2:
			if (categoryDAO.getSecondCategory(categoryVO).isEmpty()) {
				errors.reject("CategoryId", "No data.");
			}
			return;
		case 3:
			if (categoryDAO.getThirdCategory(categoryVO).isEmpty()) {
				errors.reject("CategoryId", "No data.");
			}
			return;
		}
	}
	
	public boolean levelCheck(int level, Errors errors) {
		if (level < 1 || level > 3) {
			errors.reject("categoriesLevel", "value error");
			return false;
		}	
		return true;
	}
	
	public boolean actionCheck(int categoryAction, Errors errors) {
		if (categoryAction != 1 && categoryAction != -1) {
			errors.reject("categoriesLevel", "value error");
			return false;
		}
		return true;
	}
}
