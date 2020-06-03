package com.jh.pm.purchaseitem;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PmPurchaseItemDAO {
	
	@Autowired SqlSessionTemplate template;
	
	//발주 아이템 다중 삽입
	public int insertPurchaseItem(PmPurchaseItemVO pmPurchaseItemVO) {
		return template.insert("PmPurchaseItemDAO.insertPurchaseItem",pmPurchaseItemVO);
	}
	//발주 아아템 다중 삭제
	public int deletePurchaseItem(String id) {
		return template.delete("PmPurchaseItemDAO.deletePurchaseItem", id);
	}
	
	//발주 아이템 목록 조회
	public List<PmPurchaseItemVO> getPmPurchaseItemVOList(String id){
		return template.selectList("PmPurchaseItemDAO.getPmPurchaseItemVOList", id);
	}
	
	public List<PmPurchaseItemJoinItemVO> getPmPurchaseItemJoinItem(String id){
		return template.selectList("PmPurchaseItemDAO.getPmPurchaseItemJoinItem",id);
	}
	
}
