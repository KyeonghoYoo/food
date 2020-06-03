package com.jh.cd.controller.item;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jh.cd.service.item.cd_ItemService;
import com.jh.cd.service.item.cd_ItemVO;

@CrossOrigin(origins = "*")
@RestController
public class ItemSearchController {

	@Autowired
	cd_ItemService itemService;
	
	//물품 검색
	@RequestMapping(value="item/customersearch", method=RequestMethod.GET)
	public List<cd_ItemVO> getSearchedItemList(@RequestParam("keyword") String keyword){
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("keyword", keyword);
		return itemService.getSearchItemList(params);
	}
}
