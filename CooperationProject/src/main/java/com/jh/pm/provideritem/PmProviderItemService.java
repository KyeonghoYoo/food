package com.jh.pm.provideritem;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jh.pm.provider.PmProviderVO;

@Service
public class PmProviderItemService {

	@Autowired PmProviderItemDAO providerItemDAO;
	
	public int insertProviderItems(PmProviderVO pmProviderVO) {
		for (PmProviderItemVO pmProviderItemVO : pmProviderVO.getPmProviderItemVOs()) {
			pmProviderItemVO.setTbProvider_ID(pmProviderVO.getId());
			if (providerItemDAO.insertProviderItem(pmProviderItemVO) == 0) {
				return 0;
			}
		}
		return 1;
	}
	//매입처 아아템 다중 삭제
	public int deleteProviderItem(List<PmProviderItemVO> pmProviderVOs) {
		for (PmProviderItemVO pmProviderItemVO : pmProviderVOs) {
			if (providerItemDAO.deleteProviderItem(pmProviderItemVO.getId()) == 0) {
				return 0;
			}
		} 
		return 1;
	}
	
	//매입처 아이템 목록 조회
	public List<PmProviderItemVO> getPmProviderItemVOList(String id){
		return providerItemDAO.getPmProviderItemVOList(id);
	}
	public List<PmProviderItemJoinItemVO> getPmProviderItemJoinItem(String id){
		return providerItemDAO.getPmProviderItemJoinItem(id);
	}
}
