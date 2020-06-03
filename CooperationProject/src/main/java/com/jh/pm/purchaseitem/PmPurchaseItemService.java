package com.jh.pm.purchaseitem;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PmPurchaseItemService {

	@Autowired PmPurchaseItemDAO PurchaseItemDAO;
	
	public int insertPurchaseItems(List<PmPurchaseItemVO> pmPurchaseItemVOs, String id) {
		for (PmPurchaseItemVO pmPurchaseItemVO : pmPurchaseItemVOs) {
			pmPurchaseItemVO.setTbPurchase_ID(id);
			if (PurchaseItemDAO.insertPurchaseItem(pmPurchaseItemVO) == 0) {
				return 0;
			}
		}
		return 1;
	}
	//발주 아아템 다중 삭제
	public int deletePurchaseItem(String id) {
		return PurchaseItemDAO.deletePurchaseItem(id);
	}
	
	//발주 아이템 목록 조회
	public List<PmPurchaseItemVO> getPmPurchaseItemVOList(String id){
		return PurchaseItemDAO.getPmPurchaseItemVOList(id);
	}
	public List<PmPurchaseItemJoinItemVO> getPmPurchaseItemJoinItem(String id){
		return PurchaseItemDAO.getPmPurchaseItemJoinItem(id);
	}
}
