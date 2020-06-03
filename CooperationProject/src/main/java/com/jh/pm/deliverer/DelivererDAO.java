package com.jh.pm.deliverer;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DelivererDAO {
	@Autowired SqlSessionTemplate sqlSessionTemplate;

	public int insertDeliverer(DelivererVO delivererVO) {
		return sqlSessionTemplate.insert("DelivererDAO.insertDeliverer", delivererVO);
	}

	public int updateDeliverer(DelivererVO delivererVO) {
		return sqlSessionTemplate.update("DelivererDAO.updateDeliverer", delivererVO);
	}

	public int deleteDeliverer(String id) {
		return sqlSessionTemplate.delete("DelivererDAO.deleteDeliverer", id);
	}

	public DelivererVO getDeliverer(String id) {
		return sqlSessionTemplate.selectOne("DelivererDAO.getDeliverer", id);
	}

	public List<DelivererVO> getDelivererList(DelivererVO delivererVO) {
		return sqlSessionTemplate.selectList("DelivererDAO.getDelivererList", delivererVO);
	}

}
