package com.jh.service.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerDAO customerDAO;
	
	@Override
	public CustomerVO getCustomer(CustomerVO vo) {
		return customerDAO.getCustomer(vo);
	}

}
