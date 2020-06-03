package com.jh.cd.service.item;

import java.util.HashMap;
import java.util.List;

public interface cd_ItemService {
	List<cd_ItemVO> getSearchItemList(HashMap<String, Object> params);
	cd_ItemVO getItem(String id);
	boolean updateItemQTY(HashMap<String, Object> params);
}
