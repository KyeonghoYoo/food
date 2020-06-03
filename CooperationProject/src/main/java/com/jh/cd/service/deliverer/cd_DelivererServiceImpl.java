package com.jh.cd.service.deliverer;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class cd_DelivererServiceImpl implements cd_DelivererService {

	@Autowired
	private cd_DelivererDAO delivererDAO;
	
	@Override
	public HashMap<String, Object> getDeliverer(HashMap<String, Object> delivererInfo) {
		return delivererDAO.getDeliverer(delivererInfo);
	}


}
