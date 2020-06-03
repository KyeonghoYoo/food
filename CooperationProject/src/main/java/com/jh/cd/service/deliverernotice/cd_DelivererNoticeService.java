package com.jh.cd.service.deliverernotice;

import java.util.HashMap;
import java.util.List;

public interface cd_DelivererNoticeService {

	List<HashMap<String, Object>> getDelivererNoticeList();

	cd_DelivererNoticeVO getDelivererNotice(String id);

}