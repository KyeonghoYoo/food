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
		System.out.println("=======> getCustomerNoticeList() ��� ó��");
		return mybatis.selectList("cd_CustomerNoitce.getCustomerNoticeList");
	}
	
	public cd_CustomerNoticeVO getCustomerNotice(String id){
		System.out.println("=======> getCustomerNotice() ��� ó��");
		return mybatis.selectOne("cd_CustomerNoitce.getCustomerNotice", id);
	}
}
