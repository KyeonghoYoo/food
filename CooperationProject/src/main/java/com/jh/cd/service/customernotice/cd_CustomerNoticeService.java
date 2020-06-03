package com.jh.cd.service.customernotice;

import java.util.HashMap;
import java.util.List;

public interface cd_CustomerNoticeService {

	List<HashMap<String, Object>> getCustomerNoticeList();

	cd_CustomerNoticeVO getCustomerNotice(String id);

}