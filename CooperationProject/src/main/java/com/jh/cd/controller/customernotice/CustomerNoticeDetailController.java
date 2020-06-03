package com.jh.cd.controller.customernotice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jh.cd.service.customernotice.cd_CustomerNoticeService;
import com.jh.cd.service.customernotice.cd_CustomerNoticeVO;

@CrossOrigin(origins="*")
@RestController
public class CustomerNoticeDetailController {
	
	@Autowired
	private cd_CustomerNoticeService customerNoticeService;
	
	//�ŷ�ó �������� ��
	@RequestMapping(value = "/customernotice/{id}", method = RequestMethod.GET)
	public cd_CustomerNoticeVO getCustomerNotice(@PathVariable("id") String id) {
		return customerNoticeService.getCustomerNotice(id);
	}

}
