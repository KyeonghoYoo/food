package com.jh.pm.provider;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PmProviderDAO {

	@Autowired
	SqlSessionTemplate template;

	// CLASS_SELLING_PM_1.3 거래처 단일 삽입 DAO
	public int insertPmProvider(PmProviderVO pmProviderVO) {
		// CLASS_SELLING_PM_1.3.1 pmProviderVO 데이터 삽입
		return template.insert("PmProviderDAO.insertPmProvider", pmProviderVO);
	}

	// CLASS_SELLING_PM_3.3 거래처 단일 수정 DAO
	public int updatePmProvider(PmProviderVO pmProviderVO) {
		// CLASS_SELLING_PM_3.3.1 pmProviderVO 데이터 수정
		return template.update("PmProviderDAO.updatePmProvider", pmProviderVO);
	}

	// CLASS_SELLING_PM_6.3 거래처 단일 삭제 DAO
	public int deletePmProvider(String id) {
		// CLASS_SELLING_PM_6.3.1 거래처 id 해당 된는 튜플 삭제
		return template.delete("PmProviderDAO.deletePmProvider", id);
	}
	//CLASS_SELLING_PM_8.3 거래처 정보 조회 DAO
	public List<PmProviderVO> getPmProviders(PmProviderVO pmProviderVO) {
		//CLASS_SELLING_PM_8.3.1 개러처 정보 조회
		return template.selectList("PmProviderDAO.getPmProviders", pmProviderVO);
	}

	public PmProviderVO getPmProvider(String id) {
		return template.selectOne("PmProviderDAO.getPmProvider", id);
	}
}
