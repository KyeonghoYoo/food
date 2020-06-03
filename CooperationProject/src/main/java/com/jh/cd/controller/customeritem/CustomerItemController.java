package com.jh.cd.controller.customeritem;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jh.cd.service.customer.cd_CustomerVO;
import com.jh.cd.service.customeritem.cd_CustomerItemService;
import com.jh.cd.service.item.cd_ItemVO;

@CrossOrigin(origins = "*")
@RestController
public class CustomerItemController {

	@Autowired
	private cd_CustomerItemService customerItemService;

	// �ֹ� ���ã�� ȭ��
	@RequestMapping(value = "/customeritem/{userid}", method = RequestMethod.GET)
	public HashMap<String, Object> getCustomerItemLists(@PathVariable("userid") String userid) {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		cd_CustomerVO vo = new cd_CustomerVO();
		vo.setId(userid);
		cd_CustomerVO customerVO = customerItemService.getCustomerAddress(vo);
		try {
			resultMap.put("userAddress", customerVO.getAddress1() + ' ' + customerVO.getAddress2() + ' '
					+ customerVO.getAddress3() + " (" + customerVO.getBname() + ")");
			resultMap.put("customerItemList", (List<cd_ItemVO>) customerItemService.getCustomerItemList(vo));
			System.out.println(resultMap.toString());
		} catch (Exception e) {
			resultMap.put("result", "fail");
			return resultMap;
		}

		return resultMap;
	}
}
