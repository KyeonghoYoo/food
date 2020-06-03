package com.jh.cd.service.orderitem;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class cd_OrderItemDAO {
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public List<cd_OrderItemVO> getOrderItemList(String orderId){
		System.out.println("=======> getOrderItemList() 扁瓷 贸府");
		return mybatis.selectList("cd_OrderItem.getOrderItemList", orderId);
	}
	
	public boolean insertOrderItem(HashMap<String, Object> params) {
		System.out.println("=======> insertOrderItem() 扁瓷 贸府");
		boolean result = true;
		mybatis.insert("cd_OrderItem.insertOrderItem", params);
		return result;
	}
	public boolean updateOrderItemState(HashMap<String, Object> params) {
		boolean result = true;
		mybatis.update("cd_OrderItem.updateOrderItemState", params);
		return  result;
	}
}
