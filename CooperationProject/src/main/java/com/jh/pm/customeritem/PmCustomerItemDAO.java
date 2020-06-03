package com.jh.pm.customeritem;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PmCustomerItemDAO {
	
	@Autowired
	SqlSessionTemplate template;
	
	//PM_CS_APP_10.3 거래처 아이템 단일 등록 DAO
	public int insertCustomerItem(PmCustomerItemVO customerItemVO) {
		//PM_CS_APP_10.3.1 거래처 아이템 단일 등록
		return template.insert("CustomerItemDAO.insertCustomerItem", customerItemVO);
	}
	//PM_CS_APP_12.3 거래처 아이템 단일 수정 DAO
	public int updateCustomerItem(PmCustomerItemVO customerItemVO) {
		//PM_CS_APP_12.3.1 거래처 아이템 단일 수정
		return template.insert("CustomerItemDAO.updateCustomerItem", customerItemVO);
	}
	//PM_CS_APP_14.3 거래처 아이템 단일 삭제 DAO
	public int deleteCustomerItem(String id) {
		//PM_CS_APP_14.3.1 거래처 아이템 단일 삭제
		return template.insert("CustomerItemDAO.deleteCustomerItem", id);
	}
	//PM_CS_APP_16.3 거래처 아이템 목록 조회 DAO
	public List<PmCustomerItemVOJoinItemVO> getCustomerItems(String id) {
		//PM_CS_APP_16.3.1 거래처 아이템 목록 조회
		return template.selectList("CustomerItemDAO.getCustomerItems", id);
	}
	
	
		
			

}
