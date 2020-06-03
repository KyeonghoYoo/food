package com.jh.pm.orderitem;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PmOrderItamDAO {
	
	@Autowired SqlSessionTemplate template;
	
	//주문 아이템 다중 삽입
	public int insertOrderItem(PmOrderItamVO pmOrderItamVO) {
		return template.insert("PmOrderItamDAO.insertOrderItem",pmOrderItamVO);
	}
	//주문 아아템 다중 삭제
	public int deleteOrderItem(String id) {
		return template.delete("PmOrderItamDAO.deleteOrderItem", id);
	}
	
	//주문 아이템 목록 조회
	public List<PmOrderItamVO> getPmOrderItamVOList(String id){
		return template.selectList("PmOrderItamDAO.getPmOrderItamVOList", id);
	}
	
	public List<PmOrderItemJoinItemVO> getPmOrderItemJoinItem(String id){
		return template.selectList("PmOrderItamDAO.getPmOrderItemJoinItem",id);
	}
	
}
