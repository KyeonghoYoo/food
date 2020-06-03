package com.jh.pm.customeritem;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/pmCustomerItems")
public class PmCustomerItemController {
	
	@Autowired PmCustomerItemService customerItemService;
	
	//PM_CS_APP_10.1 거래처 아이템 단일 등록 Controller
	@PostMapping
	public ResponseEntity<String> insertCustomerItem(@RequestBody PmCustomerItemVO customerItemVO){
		System.out.println(customerItemVO.toString());
		//PM_CS_APP_10.1.1 거래처 아이템 유효성 검사
			//PM_CS_APP_10.1.1.1 거래처가 존재하는지 확인
			//PM_CS_APP_10.1.1.2 아이템이 존재하는지 확인
		
		//PM_CS_APP_10.1.2 거래처 아이템 단일 등록
		if (customerItemService.insertCustomerItem(customerItemVO) == 0) {
			return ResponseEntity.badRequest().build();
		} 
		return ResponseEntity.ok().build(); 
	} 
	//PM_CS_APP_11.1 거래처 아이템 다중 등록 Controller
	@PostMapping("/multi")
	public ResponseEntity<String> insertCustomerItems(@RequestBody List<PmCustomerItemVO> customerItemVOs){
		//PM_CS_APP_11.1.1 거래처 아이템 유효성 검사
			//PM_CS_APP_11.1.1.1 거래처가 존재하는지 확인
			//PM_CS_APP_11.1.1.2 아이템이 존재하는지 확인
		
		//PM_CS_APP_10.1.2 거래처 아이템 다중 등록
		if (customerItemService.insertCustomerItems(customerItemVOs) == 0) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok().build();
	}
	//PM_CS_APP_12.1 거래처 아이템 단일 수정 Controller
	@PutMapping("/{id}")
	public 	ResponseEntity<String> updateCustomerItem(@RequestBody PmCustomerItemVO customerItemVO, @PathVariable String id){
		//PM_CS_APP_12.1.1 거래처 아이템 유효성 검사
			//PM_CS_APP_12.1.1.1 거래처가 존재하는지 확인
			//PM_CS_APP_12.1.1.2 아이템이 존재하는지 확인
		
		customerItemVO.setId(id);
		System.out.println(customerItemVO.toString());
		//PM_CS_APP_10.1.2 거래처 아이템 단일 수정
		if (customerItemService.updateCustomerItem(customerItemVO) == 0) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok().build();
	}
	//PM_CS_APP_14.1 거래처 아이템 단일 수정 Controller
	@DeleteMapping("/{id}")
	public 	ResponseEntity<String> deleteCustomerItem(@PathVariable String id){
		//PM_CS_APP_14.1.1 거래처 아이템 유효성 검사
			
		
		//PM_CS_APP_14.1.2 거래처 아이템 단일 삭제
		if (customerItemService.deleteCustomerItem(id) == 0) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok().build();
	}
	
	//PM_CS_APP_15.1 거래처 아이템 다중 삭제 Controller
	@DeleteMapping
	public ResponseEntity<String> deleteCustomerItems(@RequestBody List<Map<String, String>> ids) {
		// PM_CS_APP_15.1.1 거래처 아이템 유효성 검사

		// PM_CS_APP_14.1.2 거래처 아이템 다중 삭제
		if (customerItemService.deleteCustomerItems(ids) == 0) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/{id}")
	//PM_CS_APP_16.1 거래처 아이템 목록 조회 Controller
	public ResponseEntity<List<PmCustomerItemVOJoinItemVO>> getCustomerItems(@PathVariable String id){
		//PM_CS_APP_16.1.1 거래처 유효성 검사
		//PM_CS_APP_16.1.2 거래처 목록 조회
		List<PmCustomerItemVOJoinItemVO> customerItemVOJoinItemVOs = customerItemService.getCustomerItems(id);
		return ResponseEntity.ok(customerItemVOJoinItemVOs);
	}
	
}
