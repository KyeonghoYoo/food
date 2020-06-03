package com.jh.cd.controller.orderitem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jh.cd.service.item.cd_ItemService;
import com.jh.cd.service.order.cd_OrderService;
import com.jh.cd.service.orderitem.cd_OrderItemService;
import com.jh.cd.service.orderitem.cd_OrderItemVO;
import com.jh.cd.util.DateUtil;

@CrossOrigin(origins = "*")
@RestController
public class OrderDetailCotroller {
	
	@Autowired
	private cd_OrderItemService orderItemService;
	
	@Autowired
	private cd_ItemService itemService;
	
	@Autowired
	private cd_OrderService orderService;

	
	// �ֹ� �󼼺���
	@RequestMapping(value = "/orderdetail/{orderId}", method = RequestMethod.GET)
	public ArrayList<HashMap<String, Object>> getRefundList(@PathVariable("orderId") String orderId) {
		ArrayList<HashMap<String, Object>> resultList = new ArrayList<HashMap<String, Object>>();
		List<cd_OrderItemVO> orderItemList = orderItemService.getOrderItemList(orderId);
		
		for(int i = 0; i < orderItemList.size(); i++) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("orderitem", orderItemList.get(i));
			map.put("item", itemService.getItem(orderItemList.get(i).getTbItem_Id()));
			resultList.add(map);
		}
		
		return resultList;
	}
	
	//����� ��ۿϷ� ó��, ��ǰ���� ó��
	@RequestMapping(value = "/orderdetail", method = RequestMethod.PUT)
	public boolean updateOrderState(@RequestBody Map<String, Object> requestInfo) {
		boolean result = true;
		DateUtil dateUtil = new DateUtil();
		String cDate = dateUtil.getCurrentDate();
		
		
		JSONObject jsonObject = new JSONObject(requestInfo);
		JSONArray itemJSONArray = jsonObject.optJSONArray("orderItemList");
		HashMap<String, Object> orderParams = new HashMap<String, Object>();
		String orderId = jsonObject.optString("orderId");
		String orderState = jsonObject.optString("orderState");
		orderParams.put("orderId", orderId);
		orderParams.put("orderState", orderState);
		orderParams.put("updateDate", cDate);
		orderService.updateOrderState(orderParams);
		
		ArrayList<HashMap<String, Object>> itemList = new ArrayList<HashMap<String, Object>>();
		for (int i = 0; i < itemJSONArray.length(); i++) {
			JSONObject jo = (JSONObject) itemJSONArray.get(i);
			itemList.add((HashMap<String, Object>) jo.toMap());
		}
		
		for (int i = 0; i < itemList.size(); i++) {
			HashMap<String, Object> params = itemList.get(i);
			HashMap<String, Object> orderItemParams = new HashMap<String, Object>();
			orderItemParams.put("orderItemId", params.get("orderItemId"));
			orderItemParams.put("orderItemState", params.get("orderItemState"));
			orderItemParams.put("updateDate", cDate);
			orderItemService.updateOrderItemState(orderItemParams);
		}
		
		return result;
	}
}
