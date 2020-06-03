package com.jh.cd.service.item;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class cd_ItemServiceImpl implements cd_ItemService {
	@Autowired
	private cd_ItemDAO itemDAO;
	
	@Override
	public List<cd_ItemVO> getSearchItemList(HashMap<String, Object> params) {
		return itemDAO.getSearchItemList(params);
	}
	
	@Override
	public cd_ItemVO getItem(String id) {
		return (cd_ItemVO)itemDAO.getItem(id);
	}
	@Override
	public boolean updateItemQTY(HashMap<String, Object> params) {
		return itemDAO.updateItemQTY(params);
	}
}
