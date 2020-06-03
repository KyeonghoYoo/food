package com.jh.cd.service.adboard;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class cd_ADBoardDAO {
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public List<HashMap<String, Object>> getADBoardList(){
		System.out.println("=======> getADBoardList() 기능 처리");
		return mybatis.selectList("cd_ADBoard.getADBoardList");
	}
}
