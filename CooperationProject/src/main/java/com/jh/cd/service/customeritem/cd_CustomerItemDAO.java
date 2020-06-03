package com.jh.cd.service.customeritem;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jh.cd.service.customer.cd_CustomerVO;
import com.jh.cd.service.item.cd_ItemVO;

@Repository
public class cd_CustomerItemDAO {
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public List<cd_ItemVO> getCustomerItemList(cd_CustomerVO vo) {
		System.out.println("=======> getCustomerItemList() ��� ó��");
		return mybatis.selectList("cd_CustomerItem.getCustomerItemList", vo);
	}
	public cd_CustomerVO getCustomerAddress(cd_CustomerVO vo) {
		System.out.println("=======> getCustomerAddress() ��� ó��");
		return (cd_CustomerVO) mybatis.selectOne("cd_CustomerItem.getCustomerAddress", vo);
	}
	public void insertCustomerItem(cd_CustomerItemVO vo) {
		System.out.println("=======> insertCustomerItem() ��� ó��");
		mybatis.insert("cd_CustomerItem.insertCustomerItem", vo);
	}
	public void deleteCustomerItem(cd_CustomerItemVO vo) {
		System.out.println("=======> deleteCustomerItem() ��� ó��");
		mybatis.delete("cd_CustomerItem.deleteCustomerItem", vo);
	}
}
