package com.jh.pm.item;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jh.pm.orderitem.PmOrderItamVO;

@Repository

public class PmItemDAO {

	@Autowired
	SqlSessionTemplate template;

	public void insertItem(PmItemVO vo) {
		template.insert("ItemDAO.insertItem", vo);
	}

	public List<PmItemVO> selectListItem(PmItemVO itemVO, RowBounds bounds) {
		return template.selectList("ItemDAO.selectListItem", itemVO, bounds);
	}

	public PmItemVO selectOneItem(String id) {
		return template.selectOne("ItemDAO.selectOneItem", id);
	}

	public void updateOneItem(PmItemVO itemVO) {
		template.update("ItemDAO.updateOneItem", itemVO);
	}

	public void deleteOneItem(String id) {
		template.delete("ItemDAO.deleteOneItem",id);
	}
	
	public void updateItemQTY(PmOrderItamVO orderItamVO) {
		template.update("ItemDAO.updateItemQTY",orderItamVO);
	}
}
