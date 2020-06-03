package com.jh.pm.purchase;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jh.pm.item.PmItemDAO;
import com.jh.pm.purchaseitem.PmPurchaseItemService;
import com.jh.pm.purchaseitem.PmPurchaseItemVO;

@Service
public class PmPurchaseService {

	@Autowired PmPurchaseDAO PurchaseDAO;
	@Autowired PmPurchaseItemService PmPurchaseItemService;
	@Autowired PmItemDAO itemDAO;
	
	//PM_CS_APP_17.2 발주 단일 등록 Service
	public int insertPurchase(PmPurchaseVO PurchaseVO) {
		//PM_CS_APP_17.2.1 발주 단일 등록
		PurchaseDAO.insertPurchase(PurchaseVO);
		
		// 발주 아이템 등록
		PmPurchaseItemService.insertPurchaseItems(PurchaseVO.getPmPurchaseItemVOs(),PurchaseVO.getId());
		// 아이템 수량 수정
//		for (PmPurchaseItemVO	PurchaseItamVO: PurchaseVO.getPmPurchaseItemVOs()) {
//			PurchaseItamVO.setQty(-PurchaseItamVO.getQty());
//			itemDAO.updateItemQTY(PurchaseItamVO);
//		}
		return 1;
	}

	// PM_CS_APP_18.2 발주 단일 수정 Service
	public int updatePurchase(PmPurchaseVO PurchaseVO) {
		
	    // PM_CS_APP_18.2.1 발주 단일 수정
		PurchaseDAO.updatePurchase(PurchaseVO);
		
		// 발주 아이템 조회
		List<PmPurchaseItemVO> PmPurchaseItemVOs = PmPurchaseItemService.getPmPurchaseItemVOList(PurchaseVO.getId());
		
		// 아이템 수량 수정
//		for (PmPurchaseItemVO PmPurchaseItemVO : PmPurchaseItemVOs) {
//			itemDAO.updateItemQTY(PmPurchaseItemVO);
//		}
		
		// 발주 아이템 전체 삭제
		PmPurchaseItemService.deletePurchaseItem(PurchaseVO.getId());
		
		// 발주 아이템 등록
		PmPurchaseItemService.insertPurchaseItems(PurchaseVO.getPmPurchaseItemVOs(), PurchaseVO.getId());
		
		return 1;
	}
	// PM_CS_APP_19.2 발주 다중 수정 Service
	public int updatePurchases(List<PmPurchaseVO> PurchaseVOs) {
		// PM_CS_APP_19.2.1 발주 다중 수정
		for (PmPurchaseVO PurchaseVO : PurchaseVOs) {
			if (PurchaseDAO.updatePurchase(PurchaseVO) == 0) {
				return 0;
			}
		}

		return 1;
	}

	//PM_CS_APP_20.2 발주 단일 삭제 Service
	public int deletePurchase(String id) {
		
		// 발주 아이템 조회
		List<PmPurchaseItemVO> PmPurchaseItemVOs = PmPurchaseItemService.getPmPurchaseItemVOList(id);
		
		// 아이템 수량 수정
		//for (PmPurchaseItemVO PmPurchaseItemVO : PmPurchaseItemVOs) {
		//	itemDAO.updateItemQTY(PmPurchaseItemVO);
		//}
		
		//PM_CS_APP_20.2.1 발주 단일 삭제 
		return PurchaseDAO.deletePurchase(id);
	}

	@Transactional
	public int deletePurchases(List<Map<String, String>> ids) {
		for (Map<String, String> id : ids) {
			if (PurchaseDAO.deletePurchase(id.get("id"))==0) {
				return 0;
			}
		}
		return 1;
	}

	public List<PmPurchaseVO> getPurchaseList(PmPurchaseVO PurchaseVO) {
		return PurchaseDAO.getPurchaseList(PurchaseVO);
	}

	public PmPurchaseVO getPurchase(String id) {
		// 발주 아이템 Join 아이템 목록 조회
		PmPurchaseVO PurchaseVO = PurchaseDAO.getPurchase(id);
		PurchaseVO.setPmPurchaseItemJoinItemVOs(PmPurchaseItemService.getPmPurchaseItemJoinItem(id));
		return PurchaseVO;
	}
}
