package com.jh.service.customer;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDAO {
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public CustomerVO getCustomer(CustomerVO vo) {
		System.out.println("=======> getCustomer() 기능 처리");
		return (CustomerVO) mybatis.selectOne("Customer.getCustomer", vo);
	}
}
