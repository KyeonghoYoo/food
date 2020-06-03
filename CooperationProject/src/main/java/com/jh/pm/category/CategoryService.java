package com.jh.pm.category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
	
	@Autowired CategoryDAO categoryDAO;
	
	int num = 0;
	
	FirstCategoryVO firstCategoryVO = new FirstCategoryVO();
	SecondCategoryVO secondCategoryVO = new SecondCategoryVO();
	ThirdCategoryVO thirdCategoryVO = new ThirdCategoryVO();
	
	public int insertCategory(CategoryVO vo) {
		switch (vo.getCategoriesLevel()) {
		case 1:
			return categoryDAO.insertFirstCategory(vo);
		case 2:
			return categoryDAO.insertSecondCategory(vo);
		case 3:
			return categoryDAO.insertThirdCategory(vo);
		default:
			return -1;
		}
	}

	public SelectCategory getCategoryAll(SelectCategory selectCategory) {
		selectCategory.setFirstCategoryVOs(categoryDAO.getFirstCategory(null));
		selectCategory.setSecondCategoryVOs(categoryDAO.getSecondCategory(null)); 
		selectCategory.setThirdCategoryVOs(categoryDAO.getThirdCategory(null));	
		return selectCategory;
	}
	
	public List getCategoryList(CategoryVO categoryVO) {
		switch (categoryVO.getCategoriesLevel()) {
		case 1:
			return categoryDAO.getFirstCategory(categoryVO);
		case 2:
			return categoryDAO.getSecondCategory(categoryVO);
		case 3:
			return categoryDAO.getThirdCategory(categoryVO);
		}
		return null;
	}
	
	public int updateCategory(int categoryId, int categoriesLevel, CategoryVO vo) {
		vo.setCategoryID(categoryId);
		switch (categoriesLevel) {
		case 1:
			return categoryDAO.updateFirstCategory(vo);
		case 2:
			return categoryDAO.updateSecondCategory(vo);
		case 3:
			return categoryDAO.updateThirdCategory(vo);
		}
		return -1;
	}
	
	public int deleteCategory(CategoryVO vo) {
		switch (vo.getCategoriesLevel()) {
		case 1:
			return categoryDAO.deleteFirstCategory(vo);
		case 2:
			return categoryDAO.deleteSecondCategory(vo);
		case 3:
			return categoryDAO.deleteThirdCategory(vo);
		}
		return -1;
	}
}
