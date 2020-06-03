package com.jh.cd.controller.deliverernotice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jh.cd.service.deliverernotice.cd_DelivererNoticeService;
import com.jh.cd.service.deliverernotice.cd_DelivererNoticeVO;

@CrossOrigin(origins="*")
@RestController
public class DelivererNoticeDetailController {
	
	@Autowired
	private cd_DelivererNoticeService delivererNoticeService;
	
	//����� �������� ��
	@RequestMapping(value = "/deliverernotice/{id}", method = RequestMethod.GET)
	public cd_DelivererNoticeVO getDelivererNotice(@PathVariable("id") String id) {
		return delivererNoticeService.getDelivererNotice(id);
	}

}
