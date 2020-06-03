package com.jh.cd.controller.deliverer;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jh.cd.service.deliverer.cd_DelivererService;
import com.jh.cd.service.deliverernotice.cd_DelivererNoticeService;

@CrossOrigin(origins="*")
@RestController
public class DelivererLoginController {

	@Autowired
	private cd_DelivererService delivererService;
	@Autowired
	private cd_DelivererNoticeService delivererNoticeService;
	
	//����� �α���
	
	@RequestMapping(value = "/deliverer/login", method = RequestMethod.POST)
	public HashMap<String, Object> Login(@RequestBody Map<String, Object> user) {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		HashMap<String, Object> delivererInfo = new HashMap<String, Object>();
		delivererInfo.put("userid", (String)user.get("userid"));
		delivererInfo.put("userpw", (String)user.get("userpw"));
		HashMap<String, Object> delivererResult = delivererService.getDeliverer(delivererInfo);
		
		if (delivererResult != null) {
			delivererResult.put("isAuth", true);
			resultMap.put("delivererNotice", delivererNoticeService.getDelivererNoticeList());
			resultMap.put("customer", delivererResult);
			return resultMap;
		} else {
			delivererResult=new HashMap<String, Object>();
			delivererResult.put("isAuth", false);
			resultMap.put("customer", delivererResult);
			return resultMap;
		}
	}
}
