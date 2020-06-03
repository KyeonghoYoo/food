package com.jh.cd.service.deliverernotice;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class cd_DelivererNoticeServiceImpl implements cd_DelivererNoticeService {
	@Autowired
	cd_DelivererNoticeDAO customerNoticeDAO;
	
	@Override
	public List<HashMap<String, Object>> getDelivererNoticeList(){
		return customerNoticeDAO.getDelivererNoticeList();
	}
	
	@Override
	public cd_DelivererNoticeVO getDelivererNotice(String id){
		return customerNoticeDAO.getDelivererNotice(id);
	}
}
