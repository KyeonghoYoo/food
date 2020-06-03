package com.jh.pm.provider;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jh.pm.provideritem.PmProviderItemService;
import com.jh.pm.provideritem.PmProviderItemVO;

@Service
public class PmProviderService {

	@Autowired
	PmProviderDAO ProviderDAO;
	@Autowired
	PmProviderItemService providerItemService;

	// CLASS_SELLING_PM_1.2.1 매입처 단일 삽입 Service
	public int insertPmProvider(PmProviderVO pmProviderVO) {
		// CLASS_SELLING_PM_1.2.1 매입처 pmProviderVO 데이터 삽입
		ProviderDAO.insertPmProvider(pmProviderVO);
		
		if(pmProviderVO.getPmProviderItemVOs() != null)
			providerItemService.insertProviderItems(pmProviderVO);
		
		return 1;
	}

	// CLASS_SELLING_PM_3.2 매입처 단일 수정 Service
	public int updatePmProvider(PmProviderVO pmProviderVO) {
		// CLASS_SELLING_PM_1.2.1 매입처 pmProviderVO로 정보 수정
		ProviderDAO.updatePmProvider(pmProviderVO);
		
		List<PmProviderItemVO> pmOrderItamVOs = providerItemService.getPmProviderItemVOList(pmProviderVO.getId());
		
		// 주문 아이템 전체 삭제
		if (pmProviderVO.getPmProviderItemVOs() != null)
		{
			providerItemService.deleteProviderItem(pmOrderItamVOs);
			// 주문 아이템 등록
			providerItemService.insertProviderItems(pmProviderVO);
		}
		return 1;
	}

	// CLASS_SELLING_PM_5.2 매입처 복수 수정 Service
	@Transactional
	public int updatePmProviders(List<PmProviderVO> pmProviderVOs) {
		// CLASS_SELLING_PM_5.2.1 매입처 복수 유효성 검사

		// CLASS_SELLING_PM_5.2.2 매입처 pmProviderVOs로 정보 수정
		for (PmProviderVO pmProviderVO : pmProviderVOs)
			if (ProviderDAO.updatePmProvider(pmProviderVO) == 0)
				return 0;

		return 1;
	}

	// CLASS_SELLING_PM_6.2 매입처 단일 삭제 Service
	public int deletePmProvider(String id) {

		// CLASS_SELLING_PM_6.2.1 매입처 id 해당 된는 튜플 삭제
		return ProviderDAO.deletePmProvider(id);
	}

	// CLASS_SELLING_PM_7.2 매입처 복수 삭제 Service
	@Transactional
	public int deletePmProviders(List<Map<String, String>> ids) {
		// CLASS_SELLING_PM_7.2.1 매입처 복수 유효성 검사

		// CLASS_SELLING_PM_7.2.2 ids로 매입처 정보 삭제
		for (Map<String, String> id : ids) {
			// CLASS_SELLING_PM_7.2.3 삭제가 에러 날 때
			if (ProviderDAO.deletePmProvider(id.get("id")) == 0) {
				return 0;
			}
		}
		// CLASS_SELLING_PM_7.2.3 삭제가 정상작동 할 때
		return 1;
	}

	// CLASS_SELLING_PM_8.2 매입처 정보 조회 service
	public List<PmProviderVO> getPmProviders(PmProviderVO pmProviderVO) {
		// CLASS_SELLING_PM_8.2.1 매입처 정보 조회
		List<PmProviderVO> ProviderVOs = ProviderDAO.getPmProviders(pmProviderVO);
		// CLASS_SELLING_PM_8.2.3 주문 합계 정보 조회
		return ProviderVOs;
	}

	// CLASS_SELLING_PM_8.1 매입처 상세조회 controller
	public PmProviderVO getPmProvider(String id) {
		// CLASS_SELLING_PM_8.1 매입처 상세조회 controller
		//매입처 정보 조회
		PmProviderVO vo = ProviderDAO.getPmProvider(id);
		//매입처 아이템 리스트 세팅
		vo.setPmProviderJoinItemVOs(providerItemService.getPmProviderItemJoinItem(id));
		return vo;
	}

}
