package com.jh.cd.controller.customeritem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jh.cd.service.customeritem.cd_CustomerItemService;
import com.jh.cd.service.customeritem.cd_CustomerItemVO;

@CrossOrigin(origins = "*")
@RestController
public class DeleteCustomerItemController {

	@Autowired
	private cd_CustomerItemService customerItemService;
	//���ã�� ����
	@RequestMapping(value = "/deletecustomeritem", method = RequestMethod.DELETE)
	public void getCustomerItemLists(@RequestBody Map<String, Object> customerItemInfo) {
		//����� ���� ����
		JSONObject jsonObject = new JSONObject(customerItemInfo);
		JSONArray itemJSONArray = jsonObject.optJSONArray("customerItemList");

		ArrayList<HashMap<String, Object>> itemList = new ArrayList<HashMap<String, Object>>();
		
		for (int i = 0; i < itemJSONArray.length(); i++) {
			JSONObject jo = (JSONObject) itemJSONArray.get(i);
			itemList.add((HashMap<String, Object>) jo.toMap());
		}

		String tbCustomer_ID = (String) customerItemInfo.get("tbCustomer_ID");
		
		for(int i = 0; i < itemList.size(); i++) {
			HashMap<String, Object> item = itemList.get(i);
			cd_CustomerItemVO vo = new cd_CustomerItemVO();
			vo.setTbCustomer_ID(tbCustomer_ID);
			vo.setTbItem_ID((String)item.get("tbItem_ID"));
			
			// ������ ������
			customerItemService.deleteCustomerItem(vo);
		}
		
		return;
	}
}
