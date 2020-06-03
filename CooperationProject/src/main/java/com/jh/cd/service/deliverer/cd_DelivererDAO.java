package com.jh.cd.service.deliverer;

import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class cd_DelivererDAO {
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public HashMap<String, Object> getDeliverer(HashMap<String, Object> delivererInfo) {
		System.out.println("=======> getDeliverer() 기능 처리");
		return (HashMap<String, Object>) mybatis.selectOne("cd_Deliverer.getDeliverer", delivererInfo);
	}
	

}
