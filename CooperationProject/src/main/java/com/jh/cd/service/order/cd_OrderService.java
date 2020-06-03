package com.jh.cd.service.order;

import java.util.HashMap;
import java.util.List;

public interface cd_OrderService {

	boolean insertOrder(cd_OrderVO vo);

	List<cd_OrderVO> getOrderList(HashMap<String, Object> params);

	List<cd_OrderVO> getRefundList(HashMap<String, Object> params);

	HashMap<String, Object> getOrderStatistics(HashMap<String, Object> params);

	List<HashMap<String, Object>> getOrderItemStatistics(HashMap<String, Object> params);

	cd_OrderVO getLatestOrderId(String customerId);

	List<cd_OrderVO> getDelivererOrderList(HashMap<String, Object> params);

	List<cd_OrderVO> getDelivererRefundList(HashMap<String, Object> params);

	boolean updateOrderState(HashMap<String, Object> params);

	boolean cancelOrder(String orderId);
}