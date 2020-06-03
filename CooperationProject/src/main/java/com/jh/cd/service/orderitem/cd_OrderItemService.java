package com.jh.cd.service.orderitem;

import java.util.HashMap;
import java.util.List;

public interface cd_OrderItemService {

	List<cd_OrderItemVO> getOrderItemList(String orderId);
	
	boolean insertOrderItem(HashMap<String, Object> params);
	
	boolean updateOrderItemState(HashMap<String, Object> params);

}