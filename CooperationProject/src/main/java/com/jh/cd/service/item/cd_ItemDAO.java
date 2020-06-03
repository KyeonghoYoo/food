package com.jh.cd.service.item;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class cd_ItemDAO {
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public List<cd_ItemVO> getSearchItemList(HashMap<String, Object> params) {
		System.out.println("=======> getSearchItemList() ��� ó��");
		return mybatis.selectList("cd_Item.getSearchItemList", params);
	}
	
	public cd_ItemVO getItem(String id) {
		System.out.println("=======> getItem() ��� ó��");
		return (cd_ItemVO)mybatis.selectOne("cd_Item.getItem", id);
	}
	
	public boolean updateItemQTY(HashMap<String, Object> params) {
		System.out.println("=======> updateItemQTY() ��� ó��");
		boolean result = true;
		mybatis.update("cd_Item.updateItemQTY", params);
		return result;
	}
}
