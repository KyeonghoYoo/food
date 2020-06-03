package com.jh.pm.item;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

import com.jh.common.StaicKeyWord;
import com.jh.common.UploadBiz;
import com.jh.pm.category.CategoryDAO;
import com.jh.pm.category.CategoryVO;

@Service
public class PmItemService {
	
	@Autowired PmItemDAO itemDAO;
	@Autowired UploadBiz uploadBiz;
	@Autowired CategoryDAO categoryDAO;
	

	public void insertItem(PmItemVO vo) throws Exception {
		itemDAO.insertItem(vo);
		uploadBiz.uploadAjaxPOST(vo.getItemImage(), vo.getId(), StaicKeyWord.PATH_ITEM);
	}

	public List<PmItemVO> selectListItem(PmItemVO itemVO, RowBounds bounds) {
		return itemDAO.selectListItem(itemVO, bounds);
	}

	public PmSelectOneItemVO selectOneItem(PmItemVO itemVO, Errors errors) {
		PmSelectOneItemVO selectOneItemVO = new PmSelectOneItemVO();
		selectOneItemVO.setItemVO(itemVO);
		
		//1차 카테고리 정보 조회
		if (itemVO.getFirstCategory_ID() != 0) {
			CategoryVO categoryVO = new CategoryVO();
			categoryVO.setCategoryID(itemVO.getFirstCategory_ID());
			categoryVO.setCategoriesLevel(StaicKeyWord.FIRST);
			selectOneItemVO.setFirstCategoryVO(categoryDAO.getFirstCategory(categoryVO).get(0));
		}
		//2차 카테고리 정보 조회
		if (itemVO.getSecondCategory_ID() != 0) {
			CategoryVO categoryVO = new CategoryVO();
			categoryVO.setCategoryID(itemVO.getSecondCategory_ID());
			categoryVO.setCategoriesLevel(StaicKeyWord.SECOND);
			selectOneItemVO.setSecondCategoryVO(categoryDAO.getSecondCategory(categoryVO).get(0));
		}
		
		//3차 카테고리 정보 조회
		if (itemVO.getThirdCategory_ID() != 0) {
			CategoryVO categoryVO = new CategoryVO();
			categoryVO.setCategoryID(itemVO.getThirdCategory_ID());
			categoryVO.setCategoriesLevel(StaicKeyWord.THIRD);
			selectOneItemVO.setThirdCategoryVO(categoryDAO.getThirdCategory(categoryVO).get(0));
		}
		//창고 정보 조회
		
		//공급자 정보 조회
		
		return selectOneItemVO;
	}

	public void updateOneItem(PmItemVO itemVO) {
		itemDAO.updateOneItem(itemVO);
		if (!itemVO.getItemImage().isEmpty()) {
			uploadBiz.updateFile(itemVO.getItemImage(), itemVO.getId(), StaicKeyWord.PATH_ITEM);
		}
		
	}

	public void deleteOneItem(String id) {
		itemDAO.deleteOneItem(id);
	}

	public void updateItemList(List<PmItemVO> itemVOs) {
		for (PmItemVO itemVO : itemVOs) {
			itemDAO.updateOneItem(itemVO);	
		}
	}

	public void deleteItemLisT(List<Map<String, String>> ids) {
		for (Map<String, String> id : ids) {
			itemDAO.deleteOneItem(id.get("id"));
		}		
	}
}
