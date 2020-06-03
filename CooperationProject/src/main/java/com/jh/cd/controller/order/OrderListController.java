package com.jh.cd.controller.order;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jh.cd.service.customeritem.cd_CustomerItemService;
import com.jh.cd.service.order.cd_OrderService;
import com.jh.cd.service.order.cd_OrderVO;

@CrossOrigin(origins = "*")
@RestController
public class OrderListController {
	@Autowired
	cd_OrderService orderService;

	@Autowired
	cd_CustomerItemService customerItemService;
	
	//거래처 주문 조회
	@RequestMapping(value = "/order/getOrder/{customerId}", method = RequestMethod.GET)
	public List<cd_OrderVO> getOrderList(@PathVariable("customerId") String customerId,
									  @RequestParam(value="condition", required=false) String condition) {
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("customerId", customerId);
		params.put("condition", condition);
		return orderService.getOrderList(params);
	}
	
	//거래처 반품 조회
	@RequestMapping(value = "/order/getRefund/{customerId}", method = RequestMethod.GET)
	public List<cd_OrderVO> getRefundList(@PathVariable("customerId") String customerId,
									  @RequestParam(value="condition", required=false) String condition) {
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("customerId", customerId);
		params.put("condition", condition);
		
		return orderService.getRefundList(params);
	}
}
