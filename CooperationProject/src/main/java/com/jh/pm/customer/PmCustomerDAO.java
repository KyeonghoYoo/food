package com.jh.pm.customer;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PmCustomerDAO {

	@Autowired
	SqlSessionTemplate template;

	// CLASS_SELLING_PM_1.3 거래처 단일 삽입 DAO
	public int insertPmCustomer(PmCustomerVO pmCustomerVO) {
		// CLASS_SELLING_PM_1.3.1 pmCustomerVO 데이터 삽입
		return template.insert("PmCustomerDAO.insertPmCustomer", pmCustomerVO);
	}

	// CLASS_SELLING_PM_3.3 거래처 단일 수정 DAO
	public int updatePmCustomer(PmCustomerVO pmCustomerVO) {
		// CLASS_SELLING_PM_3.3.1 pmCustomerVO 데이터 수정
		return template.update("PmCustomerDAO.updatePmCustomer", pmCustomerVO);
	}

	// CLASS_SELLING_PM_6.3 거래처 단일 삭제 DAO
	public int deletePmCustomer(String id) {
		// CLASS_SELLING_PM_6.3.1 거래처 id 해당 된는 튜플 삭제
		return template.delete("PmCustomerDAO.deletePmCustomer", id);
	}
	//CLASS_SELLING_PM_8.3 거래처 정보 조회 DAO
	public List<PmCustomerVO> getPmCustomers(PmCustomerVO pmCustomerVO) {
		//CLASS_SELLING_PM_8.3.1 개러처 정보 조회
		return template.selectList("PmCustomerDAO.getPmCustomers", pmCustomerVO);
	}

	public PmCustomerVO getPmCustomer(String id) {
		return template.selectOne("PmCustomerDAO.getPmCustomer", id);
	}
}
