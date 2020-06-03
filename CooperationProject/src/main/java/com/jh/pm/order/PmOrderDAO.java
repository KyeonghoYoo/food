package com.jh.pm.order;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PmOrderDAO {

	@Autowired SqlSessionTemplate template;

	// PM_CS_APP_17.3 주문 단일등록 DAO
	public int insertOrder(PmOrderVO orderVO) {
		// PM_CS_APP_17.3.1 주문 단일 등록
		return template.insert("OrderDAO.insertOrder", orderVO);
	}

	// PM_CS_APP_18.3 주문 단일 수정 DAO
	public int updateOrder(PmOrderVO orderVO) {
		// PM_CS_APP_18.3.1 주문 단일 수정
		return template.update("OrderDAO.updateOrder", orderVO);
	}

	// PM_CS_APP_20.3 주문 단일 삭제 DAO
	public int deleteOrder(String id) {
		// PM_CS_APP_20.3.1 주문 단일 삭제
		return template.delete("OrderDAO.deleteOrder", id);
	}

	public List<PmOrderVO> getOrderList(PmOrderVO orderVO) {
		
		return template.selectList("OrderDAO.getOrderList", orderVO);//,
				//new RowBounds(orderVO.getOffset(), orderVO.getLimit()));
	}

	public PmOrderVO getOrder(String id) {
		return template.selectOne("OrderDAO.getOrder", id);
	}

}
