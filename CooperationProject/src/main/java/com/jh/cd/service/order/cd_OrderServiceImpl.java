package com.jh.cd.service.order;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class cd_OrderServiceImpl implements cd_OrderService {


	@Autowired
	cd_OrderDAO orderDAO;
	
	@Override
	public boolean insertOrder(cd_OrderVO vo) {
		return orderDAO.insertOrder(vo);
	}
	@Override
	public cd_OrderVO getLatestOrderId(String customerId) {
		return orderDAO.getLatestOrderId(customerId);
	}
	@Override
	public List<cd_OrderVO> getOrderList(HashMap<String, Object> params) {
		return (List<cd_OrderVO>)orderDAO.getOrderList(params);
	}

	@Override
	public List<cd_OrderVO> getRefundList(HashMap<String, Object> params) {
		return (List<cd_OrderVO>)orderDAO.getRefundList(params);
	}
	
	@Override
	public HashMap<String, Object> getOrderStatistics(HashMap<String, Object> params) {
		return orderDAO.getOrderStatistics(params);
	}
	@Override
	public List<HashMap<String, Object>> getOrderItemStatistics(HashMap<String, Object> params) {
		return orderDAO.getOrderItemStatistics(params);
	}
	@Override
	public List<cd_OrderVO> getDelivererOrderList(HashMap<String, Object> params){
		return orderDAO.getDelivererOrderList(params);
	}
	@Override
	public List<cd_OrderVO> getDelivererRefundList(HashMap<String, Object> params){
		return orderDAO.getDelivererRefundList(params);
	}
	
	@Override
	public boolean updateOrderState(HashMap<String, Object> params) {
		return orderDAO.updateOrderState(params);
	}
	
	@Override
	public boolean cancelOrder(String orderId) {
		return orderDAO.cancelOrder(orderId);
	}
}
