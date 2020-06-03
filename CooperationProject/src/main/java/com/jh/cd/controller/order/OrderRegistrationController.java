package com.jh.cd.controller.order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jh.cd.service.customer.cd_CustomerVO;
import com.jh.cd.service.customeritem.cd_CustomerItemService;
import com.jh.cd.service.item.cd_ItemService;
import com.jh.cd.service.order.cd_OrderService;
import com.jh.cd.service.order.cd_OrderVO;
import com.jh.cd.service.orderitem.cd_OrderItemService;
import com.jh.cd.util.DateUtil;

@CrossOrigin(origins = "*")
@RestController
public class OrderRegistrationController {
	@Autowired
	cd_OrderService orderService;

	@Autowired
	cd_CustomerItemService customerItemService;
	@Autowired
	cd_OrderItemService orderItemService;
	@Autowired
	cd_ItemService itemservice;

	//�ֹ� ���
	@RequestMapping(value = "/order/insert", method = RequestMethod.POST)
	public boolean insertOrder(@RequestBody Map<String, Object> orderInfo) {
		boolean result = true;
		cd_OrderVO orderVO = new cd_OrderVO();

		JSONObject jsonObject = new JSONObject(orderInfo);
		JSONArray itemJSONArray = jsonObject.optJSONArray("orderItemList");

		ArrayList<HashMap<String, Object>> itemList = new ArrayList<HashMap<String, Object>>();

		
		for (int i = 0; i < itemJSONArray.length(); i++) {
			JSONObject jo = (JSONObject) itemJSONArray.get(i);
			itemList.add((HashMap<String, Object>) jo.toMap());
		}

		DateUtil dateUtil = new DateUtil();
		String cDate = dateUtil.getCurrentDate();

		cd_CustomerVO customerVO = new cd_CustomerVO();
		customerVO.setId(jsonObject.optString("userId"));
		customerVO = customerItemService.getCustomerAddress(customerVO);

		orderVO.setTbcustomer_id(customerVO.getId());
		orderVO.setTbdeliverer_id(customerVO.getTbDeliverer_ID());
		orderVO.setSalespersonid(customerVO.getSalesman_ID());
		orderVO.setOrderdate(cDate);
		orderVO.setUpdatedate(cDate);
		orderVO.setAddress1(customerVO.getAddress1());
		orderVO.setAddress2(customerVO.getAddress2());
		orderVO.setAddress3(customerVO.getAddress3());
		orderVO.setItemcount(itemList.size());
		orderVO.setRegdate(jsonObject.optString("reqDate"));
		orderVO.setAmount(jsonObject.optInt("amount"));
		orderVO.setPoints(jsonObject.optInt("points"));
		orderVO.setPayment(jsonObject.optInt("amount"));
		orderVO.setPaymethod(jsonObject.optString("payMethod"));
		orderVO.setRequests(jsonObject.optString("requests"));
		orderVO.setOrderstate("주문접수");
		orderVO.setMemo(jsonObject.optString("memo"));
		orderVO.setRemark1(jsonObject.optString("remark1"));
		orderVO.setRemark2(jsonObject.optString("remark2"));
		orderService.insertOrder(orderVO);
		String orderId = orderService.getLatestOrderId(customerVO.getId()).getId();
		System.out.println("OrderRegistraition.OrderId :: " + orderId);
		
		for (int i = 0; i < itemList.size(); i++) {
			HashMap<String, Object> orderItemParams = new HashMap<String, Object>();
			HashMap<String, Object> item = itemList.get(i);
			orderItemParams.put("orderId", orderId);
			orderItemParams.putAll(item);
			orderItemParams.put("state", "주문접수");
			orderItemParams.put("updateDate", cDate);
			System.out.println(orderItemParams.toString());
			itemservice.updateItemQTY(item);
			orderItemService.insertOrderItem(orderItemParams);
		}
		
		return result;
	}
}
