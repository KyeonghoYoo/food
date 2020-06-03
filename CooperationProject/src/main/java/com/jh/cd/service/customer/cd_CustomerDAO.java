package com.jh.cd.service.customer;

import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class cd_CustomerDAO {
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public HashMap<String, Object> getCustomer(HashMap<String, Object> userInfo) {
		System.out.println("=======> getCustomer() 기능 처리");
		return (HashMap<String, Object>) mybatis.selectOne("cd_Customer.getCustomer", userInfo);
	}
	

}
