package com.jh.cd.service.customeritem;

import java.util.List;

import com.jh.cd.service.customer.cd_CustomerVO;
import com.jh.cd.service.item.cd_ItemVO;

public interface cd_CustomerItemService {
	List<cd_ItemVO> getCustomerItemList(cd_CustomerVO vo);
	
	cd_CustomerVO getCustomerAddress(cd_CustomerVO vo);
	
	void insertCustomerItem(cd_CustomerItemVO vo);
	
	void deleteCustomerItem(cd_CustomerItemVO vo);
}
