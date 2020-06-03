package com.jh.pm.customer;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PmCustomerService {
	
	@Autowired PmCustomerDAO customerDAO;
	
	//CLASS_SELLING_PM_1.2.1 거래처 단일 삽입 Service
	public int insertPmCustomer(PmCustomerVO pmCustomerVO) {
		//CLASS_SELLING_PM_1.2.1 거래처 pmCustomerVO 데이터 삽
		return customerDAO.insertPmCustomer(pmCustomerVO);
	}
	
	//CLASS_SELLING_PM_3.2 거래처 단일 수정 Service
	public int updatePmCustomer(PmCustomerVO pmCustomerVO) {
		//CLASS_SELLING_PM_1.2.1 거래처 pmCustomerVO로 정보 수정
		return customerDAO.updatePmCustomer(pmCustomerVO);
	}
	//CLASS_SELLING_PM_5.2 거래처 복수 수정 Service
	@Transactional
	public int updatePmCustomers(List<PmCustomerVO> pmCustomerVOs) {
		//CLASS_SELLING_PM_5.2.1 거래처 복수 유효성 검사
		
		//CLASS_SELLING_PM_5.2.2 거래처 pmCustomerVOs로 정보 수정
		for (PmCustomerVO pmCustomerVO : pmCustomerVOs) 
			if (customerDAO.updatePmCustomer(pmCustomerVO) == 0) 
				return 0;		
		
		return 1;
	}
	
	//CLASS_SELLING_PM_6.2 거래처 단일 삭제 Service
	public int deletePmCustomer(String id) {
		
		//CLASS_SELLING_PM_6.2.1 거래처 id 해당 된는 튜플 삭제
		return customerDAO.deletePmCustomer(id);
	}
	
	//CLASS_SELLING_PM_7.2 거래처 복수 삭제 Service
	@Transactional
	public int deletePmCustomers(List<Map<String, String>> ids) {
		//CLASS_SELLING_PM_7.2.1 거래처 복수 유효성 검사
		
		//CLASS_SELLING_PM_7.2.2 ids로 거래처 정보 삭제
		for (Map<String, String> id : ids) {
			//CLASS_SELLING_PM_7.2.3 삭제가 에러 날 때
			if (customerDAO.deletePmCustomer(id.get("id")) == 0) {
				return 0;
			}
		}
		//CLASS_SELLING_PM_7.2.3 삭제가 정상작동 할 때
		return 1;
	}
	
	// CLASS_SELLING_PM_8.2 거래처 정보 조회 service
	public List<PmCustomerVO> getPmCustomers(PmCustomerVO pmCustomerVO) {
		// CLASS_SELLING_PM_8.2.1 거래처 정보 조회
		List<PmCustomerVO> customerVOs = customerDAO.getPmCustomers(pmCustomerVO);
		// CLASS_SELLING_PM_8.2.3 주문 합계 정보 조회
		return customerVOs;
	}

	//CLASS_SELLING_PM_8.1 거래처 상세조회 controller
	public PmCustomerVO getPmCustomer(String id) {
		//CLASS_SELLING_PM_8.1 거래처 상세조회 controller
		return customerDAO.getPmCustomer(id);
	}
	
	
			
			
}
