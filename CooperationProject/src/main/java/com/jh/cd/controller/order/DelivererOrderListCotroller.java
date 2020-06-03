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

import com.jh.cd.service.customer.cd_CustomerVO;
import com.jh.cd.service.customeritem.cd_CustomerItemService;
import com.jh.cd.service.order.cd_OrderService;
import com.jh.cd.service.order.cd_OrderVO;

@CrossOrigin(origins = "*")
@RestController
public class DelivererOrderListCotroller {
	@Autowired
	cd_OrderService orderService;
	
	@Autowired
	cd_CustomerItemService customerItemService;
	
	// ��� ��ȸ
	   // 배송 조회
	   @RequestMapping(value = "/order/getDelivererOrder/{delivererId}", method = RequestMethod.GET)
	   public List<cd_OrderVO> getOrderList(@PathVariable("delivererId") String delivererId,
	                             @RequestParam("condition") String condition) {
	      HashMap<String, Object> params = new HashMap<String, Object>();
	      params.put("delivererId", delivererId);
	      params.put("condition", condition);
	      
	      List<cd_OrderVO> delivererOrderList = orderService.getDelivererOrderList(params);
	      for(int i = 0; i < delivererOrderList.size(); i++) {
	         cd_OrderVO dumy = delivererOrderList.get(i);
	         cd_CustomerVO vo = new cd_CustomerVO();
	         vo.setId(dumy.getTbcustomer_id());
	         vo = customerItemService.getCustomerAddress(vo);
	         delivererOrderList.get(i).setCustomerBname(vo.getBname());
	      }
	      
	      return delivererOrderList;
	   }
	
	   //반품 조회
	   @RequestMapping(value = "/order/getDelivererRefund/{delivererId}", method = RequestMethod.GET)
	   public List<cd_OrderVO> getRefundList(@PathVariable("delivererId") String delivererId,
	                             @RequestParam("condition") String condition) {
	      HashMap<String, Object> params = new HashMap<String, Object>();
	      params.put("delivererId", delivererId);
	      params.put("condition", condition);
	      List<cd_OrderVO> delivererRefundList = orderService.getDelivererRefundList(params);
	      for(int i = 0; i < delivererRefundList.size(); i++) {
	         cd_OrderVO dumy = delivererRefundList.get(i);
	         cd_CustomerVO vo = new cd_CustomerVO();
	         vo.setId(dumy.getTbcustomer_id());
	         vo = customerItemService.getCustomerAddress(vo);
	         delivererRefundList.get(i).setCustomerBname(vo.getBname());
	      }
	      return delivererRefundList;
	   }
}