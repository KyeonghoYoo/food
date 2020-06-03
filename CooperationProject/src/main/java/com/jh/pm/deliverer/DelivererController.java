package com.jh.pm.deliverer;

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
@RequestMapping("/deliverers")
@CrossOrigin(origins = "*")
public class DelivererController {

	@Autowired
	DelivererService delivererService;

//	배송자 단일 삽입
	@PostMapping
	public ResponseEntity<String> insertDeliverer(@RequestBody DelivererVO delivererVO) {
//		입력 정보 유효성 검사
//		배송자 단일 삽입
		if (delivererService.insertDeliverer(delivererVO) == 0) {
//			삽입 실패시 400 return
			return ResponseEntity.badRequest().build();
		}
//		정상 삽입 200 return
		return ResponseEntity.ok().build();
	}

//	배송자 단일 수정
	@PutMapping("/{id}")
	public ResponseEntity<String> updateDeliverer(@PathVariable String id, @RequestBody DelivererVO delivererVO){
//		입력 정보 유효성 검사
		delivererVO.setId(id);
//		배송자 단일 수정
		if (delivererService.updateDeliverer(delivererVO) == 0) {
//			수정 실패시 400 return
			return ResponseEntity.badRequest().build();
		}
//		정상 수정 시 200 return
		return ResponseEntity.ok().build();
	}

//	배송자 단일 삭제
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteDeliverer(@PathVariable String id) {
//		입력 정보 유효성 검사
		// 배송자 단일 삭제
		if (delivererService.deleteDeliverer(id) == 0) {
			// 삭제 실패시 400 return
			return ResponseEntity.badRequest().build();
		}
		// 정상 삭제 시 200 return
		return ResponseEntity.ok().build();
	}

//	배송자 상세 조회
	@GetMapping("/{id}")
	public ResponseEntity<DelivererVO> getDeliverer(@PathVariable String id) {
		DelivererVO delivererVO = delivererService.getDeliverer(id);
		// 배송자 상제 조회
		if (delivererVO == null) {
			// 상제 조회 결과 없을 시 400 return
			return ResponseEntity.badRequest().build();
		}
		// 정상 상세조회 시 200 return
		return ResponseEntity.ok(delivererVO);
	}

//	배송자 목록 조회
	@GetMapping
	public ResponseEntity<List<DelivererVO>> getDelivererList(DelivererVO delivererVO) {
//		입력 정보 유효성 검사
		// 배송자 상제 조회
		List<DelivererVO> delivererVOs = delivererService.getDelivererList(delivererVO); 
		if (delivererVOs == null) {
//			상제 조회 결과 없을 시 400 return
			return ResponseEntity.badRequest().build();
		}
		// 정상 상세조회 시 200 return
		return ResponseEntity.ok(delivererVOs);
	}

//	배송자 다중 수정
	@PutMapping
	public ResponseEntity<String> updateDeliverers(@RequestBody List<DelivererVO> delivererVOs) {
		// 입력 정보 유효성 검사
		// 배송자 단일 수정
		if (delivererService.updateDeliverers(delivererVOs) == 0) {
//			수정 실패시 400 return
			return ResponseEntity.badRequest().build();
		}
//		정상 수정 시 200 return
		return ResponseEntity.ok().build();
	}

//	배송자 다중 삭제
	@DeleteMapping
	public ResponseEntity<String> deleteDeliverers(@RequestBody List<Map<String, String>> ids) {
		// 입력 정보 유효성 검사
		// 배송자 단일 삭제
		if (delivererService.deleteDeliverers(ids) == 0) {
			// // 상제 조회 결과 없을 시 400 return
			return ResponseEntity.badRequest().build();
		}
//	정상 상세조회 시 200 return
		return ResponseEntity.ok().build();
	}
}
