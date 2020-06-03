package com.jh.pm.purchase;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PmPurchaseDAO {

	@Autowired SqlSessionTemplate template;

	// PM_CS_APP_17.3 발주 단일등록 DAO
	public int insertPurchase(PmPurchaseVO PurchaseVO) {
		// PM_CS_APP_17.3.1 발주 단일 등록
		return template.insert("PmPurchaseDAO.insertPurchase", PurchaseVO);
	}

	// PM_CS_APP_18.3 발주 단일 수정 DAO
	public int updatePurchase(PmPurchaseVO PurchaseVO) {
		// PM_CS_APP_18.3.1 발주 단일 수정
		return template.update("PmPurchaseDAO.updatePurchase", PurchaseVO);
	}

	// PM_CS_APP_20.3 발주 단일 삭제 DAO
	public int deletePurchase(String id) {
		// PM_CS_APP_20.3.1 발주 단일 삭제
		return template.delete("PmPurchaseDAO.deletePurchase", id);
	}

	public List<PmPurchaseVO> getPurchaseList(PmPurchaseVO PurchaseVO) {
		
		return template.selectList("PmPurchaseDAO.getPurchaseList", PurchaseVO);//,
				//new RowBounds(PurchaseVO.getOffset(), PurchaseVO.getLimit()));
	}

	public PmPurchaseVO getPurchase(String id) {
		return template.selectOne("PmPurchaseDAO.getPurchase", id);
	}

}
