package com.jh.cd.service.deliverernotice;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class cd_DelivererNoticeDAO {
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public List<HashMap<String, Object>> getDelivererNoticeList(){
		System.out.println("=======> getDelivererNoticeList() 扁瓷 贸府");
		return mybatis.selectList("cd_DelivererNoitce.getDelivererNoitceList");
	}
	
	public cd_DelivererNoticeVO getDelivererNotice(String id){
		System.out.println("=======> getDelivererNotice() 扁瓷 贸府");
		return mybatis.selectOne("cd_DelivererNoitce.getDelivererNoitce", id);
	}
}
