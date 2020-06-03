package com.jh.pm.orderitem;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PmOrderItamService {

	@Autowired PmOrderItamDAO orderItamDAO;
	
	public int insertOrderItems(List<PmOrderItamVO> pmOrderItamVOs, String id) {
		for (PmOrderItamVO pmOrderItamVO : pmOrderItamVOs) {
			pmOrderItamVO.setTbOrder_ID(id);
			if (orderItamDAO.insertOrderItem(pmOrderItamVO) == 0) {
				return 0;
			}
		}
		return 1;
	}
	//주문 아아템 다중 삭제
	public int deleteOrderItem(String id) {
		return orderItamDAO.deleteOrderItem(id);
	}
	
	//주문 아이템 목록 조회
	public List<PmOrderItamVO> getPmOrderItamVOList(String id){
		return orderItamDAO.getPmOrderItamVOList(id);
	}
	public List<PmOrderItemJoinItemVO> getPmOrderItemJoinItem(String id){
		return orderItamDAO.getPmOrderItemJoinItem(id);
	}
}
