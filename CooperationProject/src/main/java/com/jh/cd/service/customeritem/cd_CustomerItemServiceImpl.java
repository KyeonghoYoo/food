package com.jh.cd.service.customeritem;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jh.cd.service.customer.cd_CustomerVO;
import com.jh.cd.service.item.cd_ItemVO;

@Service
public class cd_CustomerItemServiceImpl implements cd_CustomerItemService {
	@Autowired
	private cd_CustomerItemDAO customerItemDAO;
	
	@Override
	public List<cd_ItemVO> getCustomerItemList(cd_CustomerVO vo) {
		return customerItemDAO.getCustomerItemList(vo);
	}
	@Override
	public cd_CustomerVO getCustomerAddress(cd_CustomerVO vo) {
		return customerItemDAO.getCustomerAddress(vo);
	}
	@Override
	public void insertCustomerItem(cd_CustomerItemVO vo) {
		customerItemDAO.insertCustomerItem(vo);
		
	}
	@Override
	public void deleteCustomerItem(cd_CustomerItemVO vo) {
		customerItemDAO.deleteCustomerItem(vo);
		
	}
	
	
	
}
