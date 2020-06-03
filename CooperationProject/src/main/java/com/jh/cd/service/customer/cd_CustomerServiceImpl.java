package com.jh.cd.service.customer;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class cd_CustomerServiceImpl implements cd_CustomerService {

	@Autowired
	private cd_CustomerDAO customerDAO;
	
	@Override
	public HashMap<String, Object> getCustomer(HashMap<String, Object> userInfo) {
		return customerDAO.getCustomer(userInfo);
	}


}
