package com.jh.cd.controller.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jh.cd.service.order.cd_OrderService;

@CrossOrigin(origins = "*")
@RestController
public class CancelOrderController {
	@Autowired
	cd_OrderService orderService;
	
	// 주문 취소
	@RequestMapping(value = "/order/cancelOrder/{orderId}", method = RequestMethod.PUT)
	public boolean getRefundList(@PathVariable("orderId") String orderId) {
		return orderService.cancelOrder(orderId);
	}
}
