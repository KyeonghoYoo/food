package com.jh.cd.service.customernotice;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class cd_CustomerNoticeDAO {
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public List<HashMap<String, Object>> getCustomerNoticeList(){
		System.out.println("=======> getCustomerNoticeList() 扁瓷 贸府");
		return mybatis.selectList("cd_CustomerNoitce.getCustomerNoticeList");
	}
	
	public cd_CustomerNoticeVO getCustomerNotice(String id){
		System.out.println("=======> getCustomerNotice() 扁瓷 贸府");
		return mybatis.selectOne("cd_CustomerNoitce.getCustomerNotice", id);
	}
}
