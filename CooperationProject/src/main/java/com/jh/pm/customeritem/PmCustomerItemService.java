package com.jh.pm.customeritem;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PmCustomerItemService {

	@Autowired PmCustomerItemDAO customerItemDAO;
	
	//PM_CS_APP_10.2 거래처 아이템 단일 등록 Service
	public int insertCustomerItem(PmCustomerItemVO customerItemVO) {
		 // PM_CS_APP_10.2.1 거래처 아이템 단일 등록
		return customerItemDAO.insertCustomerItem(customerItemVO);
		
	}
	//PM_CS_APP_11.2 거래처 아이템 단일 등록 Service
	@Transactional
	public int insertCustomerItems(List<PmCustomerItemVO> customerItemVOs) {
		//PM_CS_APP_11.2.1 거래처 아이템 다중 등록
		for (PmCustomerItemVO pmCustomerItemVO : customerItemVOs) {
			//PM_CS_APP_11.2.1 아
			if (customerItemDAO.insertCustomerItem(pmCustomerItemVO) == 0) {
				return 0;
			}
		}
		return 1;
	}
	
	//PM_CS_APP_12.2 거래처 아이템 단일 수정 Service
	public int updateCustomerItem(PmCustomerItemVO customerItemVO) {
		// PM_CS_APP_12.1 거래처 아이템 단일 수정 
		return customerItemDAO.updateCustomerItem(customerItemVO);
	}
	
	//PM_CS_APP_14.2 거래처 아이템 단일 삭제 Service
	public int deleteCustomerItem(String id) {
		// PM_CS_APP_14.1 거래처 아이템 단일 삭제 
		return customerItemDAO.deleteCustomerItem(id);
	}
	
	//PM_CS_APP_15.2 거래처 아이템 다중 삭제 Service
	public int deleteCustomerItems(List<Map<String, String>> ids) {
		// PM_CS_APP_15.2.1 거래처 아이템 다중 삭제
		for (Map<String, String> string : ids) {
			
			if (customerItemDAO.deleteCustomerItem(string.get("id")) == 0) {
				return 0;
			}
		}
		return 1;
	}
	//PM_CS_APP_16.2 거래처 아이템 목록 조회 Service

	public List<PmCustomerItemVOJoinItemVO> getCustomerItems(String id) {
		//PM_CS_APP_16.2.2 거래처 목록 조회
		return customerItemDAO.getCustomerItems(id);
	}
}