package com.jh.pm.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jh.pm.item.PmItemDAO;
import com.jh.pm.orderitem.PmOrderItamService;
import com.jh.pm.orderitem.PmOrderItamVO;

@Service
public class PmOrderService {

	@Autowired PmOrderDAO orderDAO;
	@Autowired PmOrderItamService pmOrderItamService;
	@Autowired PmItemDAO itemDAO;
	
	//PM_CS_APP_17.2 주문 단일 등록 Service
	public int insertOrder(PmOrderVO orderVO) {
		//PM_CS_APP_17.2.1 주문 단일 등록
		orderDAO.insertOrder(orderVO);
		
		// 주문 아이템 등록
		pmOrderItamService.insertOrderItems(orderVO.getPmOrderItamVOs(),orderVO.getId());
		// 아이템 수량 수정
		for (PmOrderItamVO	orderItamVO: orderVO.getPmOrderItamVOs()) {
			orderItamVO.setQty(-orderItamVO.getQty());
			itemDAO.updateItemQTY(orderItamVO);
		}
		return 1;
	}

	// PM_CS_APP_18.2 주문 단일 수정 Service
	public int updateOrder(PmOrderVO orderVO) {
		
	    // PM_CS_APP_18.2.1 주문 단일 수정
		orderDAO.updateOrder(orderVO);
		
		// 주문 아이템 조회
		List<PmOrderItamVO> pmOrderItamVOs = pmOrderItamService.getPmOrderItamVOList(orderVO.getId());
		
		// 아이템 수량 수정
		for (PmOrderItamVO pmOrderItamVO : pmOrderItamVOs) {
			itemDAO.updateItemQTY(pmOrderItamVO);
		}
		
		// 주문 아이템 전체 삭제
		pmOrderItamService.deleteOrderItem(orderVO.getId());
		
		// 주문 아이템 등록
		pmOrderItamService.insertOrderItems(orderVO.getPmOrderItamVOs(), orderVO.getId());
		
		return 1;
	}
	// PM_CS_APP_19.2 주문 다중 수정 Service
	public int updateOrders(List<PmOrderVO> orderVOs) {
		// PM_CS_APP_19.2.1 주문 다중 수정
		for (PmOrderVO orderVO : orderVOs) {
			if (orderDAO.updateOrder(orderVO) == 0) {
				return 0;
			}
		}

		return 1;
	}

	//PM_CS_APP_20.2 주문 단일 삭제 Service
	public int deleteOrder(String id) {
		
		// 주문 아이템 조회
		List<PmOrderItamVO> pmOrderItamVOs = pmOrderItamService.getPmOrderItamVOList(id);
		
		// 아이템 수량 수정
		for (PmOrderItamVO pmOrderItamVO : pmOrderItamVOs) {
			itemDAO.updateItemQTY(pmOrderItamVO);
		}
		
		//PM_CS_APP_20.2.1 주문 단일 삭제 
		return orderDAO.deleteOrder(id);
	}

	@Transactional
	public int deleteOrders(List<String> ids) {
		for (String id : ids) {
			if (orderDAO.deleteOrder(id)==0) {
				return 0;
			}
		}
		return 1;
	}

	public List<PmOrderVO> getOrderList(PmOrderVO orderVO) {
		return orderDAO.getOrderList(orderVO);
	}

	public PmOrderVO getOrder(String id) {
		// 주문 아이템 Join 아이템 목록 조회
		PmOrderVO orderVO = orderDAO.getOrder(id);
		orderVO.setPmOrderItemJoinItemVOs(pmOrderItamService.getPmOrderItemJoinItem(id));
		return orderVO;
	}
}
