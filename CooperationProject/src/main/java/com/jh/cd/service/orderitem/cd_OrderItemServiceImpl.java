package com.jh.cd.service.orderitem;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class cd_OrderItemServiceImpl implements cd_OrderItemService {

	@Autowired
	private cd_OrderItemDAO orderItemDAO;
	
	@Override
	public List<cd_OrderItemVO> getOrderItemList(String orderId) {
		return orderItemDAO.getOrderItemList(orderId);
	}
	@Override
	public boolean insertOrderItem(HashMap<String, Object> params) {
		return orderItemDAO.insertOrderItem(params);
	}
	@Override
	public boolean updateOrderItemState(HashMap<String, Object> params) {
		return  orderItemDAO.updateOrderItemState(params);
	}

}
