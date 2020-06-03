package com.jh.cd.controller.order;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jh.cd.service.order.cd_OrderService;

@CrossOrigin(origins = "*")
@RestController
public class OrderStatisticsController {
	@Autowired
	cd_OrderService orderService;
	//�ŷ�ó ��� ��ȸ
	@RequestMapping(value = "/order/statistics/{customerId}", method = RequestMethod.GET)
	public HashMap<String, Object> getRefundList(@PathVariable("customerId") String customerId,
									  @RequestParam(value="condition", required=false) String condition,
									  @RequestParam(value="startDate", required=false) String startDate,
									  @RequestParam(value="endDate", required=false) String endDate) {
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("customerId", customerId);
		params.put("condition", condition);
		params.put("startDate", startDate);
		params.put("endDate", endDate);
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("orderStatics", orderService.getOrderStatistics(params));
		resultMap.put("orderItemStatics", orderService.getOrderItemStatistics(params));
		
		return resultMap;
	}
}