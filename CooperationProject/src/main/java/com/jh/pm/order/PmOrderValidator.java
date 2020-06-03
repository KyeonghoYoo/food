package com.jh.pm.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import com.jh.pm.customer.PmCustomerDAO;
import com.jh.pm.customer.PmCustomerVO;

@Component
public class PmOrderValidator {
	@Autowired PmCustomerDAO customerDAO;
	
	//PM_CS_APP_17.5.1 주문 삽입과 관련된 거래처의 유효성 검사
	public void insertOrder(PmOrderVO orderVO, Errors errors) {
		//PM_CS_APP_17.5.1.1 거래처 상세정보 조회
		PmCustomerVO pmCustomerVO = customerDAO.getPmCustomer(orderVO.getTbCustomer_ID());
	
		//PM_CS_APP_17.5.1.2 거래처 정보가 존재 여부 확인
		if (pmCustomerVO.equals(null)) {
			//PM_CS_APP_17.5.1.2.1 거래처 정보가 없을 시 에러 추가
			errors.reject("거래처 아이디 에러","거래처 코드에 해당되는 거래처 정보가 없습니다.");
			return;
		}
		//PM_CS_APP_17.5.1.3 거래처 정보 가져오기
		orderVO.setTbDeliverer_ID(pmCustomerVO.getTbDeliverer_ID());
		orderVO.setAddress1(pmCustomerVO.getAddress1());
		orderVO.setAddress2(pmCustomerVO.getAddress2());
		orderVO.setAddress3(pmCustomerVO.getAddress3());
		orderVO.setSalesPersonID(pmCustomerVO.getSalesman_ID());
	}
	
	
}
