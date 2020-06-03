package com.jh.cd.controller.customer;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jh.cd.service.adboard.cd_ADBoardService;
import com.jh.cd.service.customer.cd_CustomerService;
import com.jh.cd.service.customernotice.cd_CustomerNoticeService;

@CrossOrigin(origins="*")
@RestController
public class CustomerLoginController {

	@Autowired
	private cd_CustomerService customerService;
	@Autowired
	private cd_CustomerNoticeService customerNoticeService;
	@Autowired
	private cd_ADBoardService adBoardService;
	
	// �ŷ�ó �α���
	@RequestMapping(value = "/customer/login", method = RequestMethod.POST)
	public HashMap<String, Object> Login(@RequestBody Map<String, Object> user) {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		HashMap<String, Object> userInfo = new HashMap<String, Object>();
		userInfo.put("userid", (String)user.get("userid"));
		userInfo.put("userpw", (String)user.get("userpw"));
		HashMap<String, Object> customerResult = customerService.getCustomer(userInfo);
		
		if (customerResult != null) {
			customerResult.put("isAuth", true);
			resultMap.put("customerNotice", customerNoticeService.getCustomerNoticeList());
			resultMap.put("adBoard", adBoardService.getADBoardList());
			resultMap.put("customer", customerResult);
			return resultMap;
		} else {
			customerResult=new HashMap<String, Object>();
			customerResult.put("isAuth", false);
			resultMap.put("customer", customerResult);
			return resultMap;
		}
	}
}
