package com.jh.cd.service.customernotice;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class cd_CustomerNoticeServiceImpl implements cd_CustomerNoticeService {
	@Autowired
	cd_CustomerNoticeDAO customerNoticeDAO;
	
	@Override
	public List<HashMap<String, Object>> getCustomerNoticeList(){
		return customerNoticeDAO.getCustomerNoticeList();
	}
	
	@Override
	public cd_CustomerNoticeVO getCustomerNotice(String id){
		return customerNoticeDAO.getCustomerNotice(id);
	}
}
