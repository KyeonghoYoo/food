package com.jh.pm.provideritem;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PmProviderItemDAO {
	
	@Autowired SqlSessionTemplate template;
	
	//매입처 아이템 다중 삽입
	public int insertProviderItem(PmProviderItemVO PmProviderItemVO) {
		return template.insert("PmProviderItemDAO.insertProviderItem", PmProviderItemVO);
	}
	//매입처 아아템 다중 삭제
	public int deleteProviderItem(String id) {
		return template.delete("PmProviderItemDAO.deleteProviderItem", id);
	}
	
	//매입처 아이템 목록 조회
	public List<PmProviderItemVO> getPmProviderItemVOList(String id){
		return template.selectList("PmProviderItemDAO.getPmProviderItemVOList", id);
	}
	public List<PmProviderItemJoinItemVO> getPmProviderItemJoinItem(String id){
		return template.selectList("PmProviderItemDAO.getPmProviderItemJoinItem",id);
	}
	
}
