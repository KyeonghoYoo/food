package com.jh.cd.service.order;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class cd_OrderDAO {
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public boolean insertOrder(cd_OrderVO vo) {
		System.out.println("=======> insertOrder() ��� ó��");
		boolean result = true;
		mybatis.insert("cd_Order.insertOrder", vo);
		return result;
	}
	
	public cd_OrderVO getLatestOrderId(String customerId) {
		return mybatis.selectOne("cd_Order.getLatestOrderId", customerId);
	}
	
	public List<cd_OrderVO> getOrderList(HashMap<String, Object> params) {
		System.out.println("=======> getOrderList() ��� ó��");
		return mybatis.selectList("cd_Order.getOrderList", params);
	}
	
	public List<cd_OrderVO> getRefundList(HashMap<String, Object> params) {
		System.out.println("=======> getRefundList() ��� ó��");
		return mybatis.selectList("cd_Order.getRefundList", params);
	}
	
	public HashMap<String, Object> getOrderStatistics(HashMap<String, Object> params) {
		System.out.println("=======> getOrderStatistics() ��� ó��");
		return mybatis.selectOne("cd_Order.getOrderStatistics", params);
	}
	public List<HashMap<String, Object>> getOrderItemStatistics(HashMap<String, Object> params) {
		System.out.println("=======> getOrderItemStatistics() ��� ó��");
		return mybatis.selectList("cd_Order.getOrderItemStatistics", params);
	}
	
	public List<cd_OrderVO> getDelivererOrderList(HashMap<String, Object> params){
		System.out.println("=======> getDelivererOrderList() ��� ó��");
		return mybatis.selectList("cd_Order.getDelivererOrderList", params);
	}
	
	public List<cd_OrderVO> getDelivererRefundList(HashMap<String, Object> params){
		System.out.println("=======> getDelivererRefundList() ��� ó��");
		return mybatis.selectList("cd_Order.getDelivererRefundList", params);
	}
	public boolean updateOrderState(HashMap<String, Object> params) {
		System.out.println("=======> updateOrderState() ��� ó��");
		boolean result = true;
		mybatis.update("cd_Order.updateOrderState", params);
		return result;
	}
	public boolean cancelOrder(String orderId) {
		System.out.println("=======> cancelOrder() ��� ó��");
		boolean result = true;
		mybatis.update("cd_Order.cancelOrder", orderId);
		return result;
	}
}
