package com.jh.pm.purchase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import com.jh.pm.provider.PmProviderDAO;
import com.jh.pm.provider.PmProviderVO;

@Component
public class PmPurchaseValidator {
	@Autowired PmProviderDAO ProviderDAO;
	
	//PM_CS_APP_17.5.1 발주 삽입과 관련된 매입처의 유효성 검사
	public void insertPurchase(PmPurchaseVO purchaseVO, Errors errors) {
		//PM_CS_APP_17.5.1.1 매입처 상세정보 조회
		PmProviderVO pmProviderVO = ProviderDAO.getPmProvider(purchaseVO.getTbProvider_ID());
	
		//PM_CS_APP_17.5.1.2 매입처 정보가 존재 여부 확인
		if (pmProviderVO.equals(null)) {
			//PM_CS_APP_17.5.1.2.1 매입처 정보가 없을 시 에러 추가
			errors.reject("매입처 아이디 에러","매입처 코드에 해당되는 매입처 정보가 없습니다.");
			return;
		}
		//PM_CS_APP_17.5.1.3 매입처 정보 가져오기
		purchaseVO.setBName(pmProviderVO.getBname());
		
	}
	
	
}
