package com.jh.cd.service.adboard;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class cd_ADBoardServiceImpl implements cd_ADBoardService {
	@Autowired
	cd_ADBoardDAO adBoardDAO;
	
	@Override
	public List<HashMap<String, Object>> getADBoardList(){
		return adBoardDAO.getADBoardList();
	}
}
