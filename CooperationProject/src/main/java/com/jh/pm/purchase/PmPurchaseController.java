package com.jh.pm.purchase;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
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
@RequestMapping("/purchases")
@CrossOrigin(origins = "*")
public class PmPurchaseController {

	@Autowired PmPurchaseService service;
	@Autowired PmPurchaseValidator PurchaseValidator;
	
	//PM_CS_APP_17.1 발주 단일 등록 Controller
	@PostMapping
	public ResponseEntity<String> insertPurchase(@RequestBody PmPurchaseVO PurchaseVO, Errors errors){
		
		//PM_CS_APP_17.1.1 매입처 유효성감사
		PurchaseValidator.insertPurchase(PurchaseVO, errors);
		
		//PM_CS_APP_17.1.2유효성 검사 결과 확인
		if (errors.hasErrors()) {
			//PM_CS_APP_17.1.2.1 에러 메시지 리턴
		}
			
		//PM_CS_APP_17.1.3 발주 단일 등록
		if (service.insertPurchase(PurchaseVO) == 0) {
			return ResponseEntity.badRequest().build();
		}	
		//PM_CS_APP_17.1.4 정상 결과 리턴
		return ResponseEntity.ok().build();
	}	
	
	//PM_CS_APP_18.1 발주 단일 수정 controller
	@PutMapping("/{id}")
	public ResponseEntity<String> updatePurchase(@PathVariable String id, @RequestBody PmPurchaseVO PurchaseVO, Errors errors){
	    //PM_CS_APP_18.1.1 유효성 검사
	        //PM_CS_APP_18.1.1.1 해당 발주값지 존재한는 지 유효성 검사
	        //PM_CS_APP_18.1.1.2 배송 요청일자 유효성 검사
	        //PM_CS_APP_18.1.1.3 배송 담당자 유효성 검사
	        //PM_CS_APP_18.1.1.4 영업 담당자 유효성 검사
	
	    //PM_CS_APP_18.1.2 유효성 검사 결과 확인
	        //PM_CS_APP_18.1.2.1 에러에 값 존재 시 에러 메시지 출력
	
		PurchaseVO.setId(id);
	    //PM_CS_APP_18.1.3 발주 단일 수정
			//PM_CS_APP_18.1.3.1 단일 수정 결과 확인
		if (service.updatePurchase(PurchaseVO)==0) {
			//PM_CS_APP_18.1.3.2 값이 0 일경우 badRequest 리턴
			return ResponseEntity.badRequest().build();
		}
	        
	    //PM_CS_APP_18.1.4 정상 처리 결과 리턴
		return ResponseEntity.ok().build();
	}
	
	//PM_CS_APP_19.1 발주 다중 수정 controller
	@PutMapping
	public ResponseEntity<String> updatePurchases(@RequestBody List<PmPurchaseVO> PurchaseVOs, Errors errors){
	    //PM_CS_APP_19.1.1 유효성 검사
        //PM_CS_APP_19.1.1.2 배송 요청일자 유효성 검사
        //PM_CS_APP_19.1.1.3 배송 담당자 유효성 검사
        //PM_CS_APP_19.1.1.4 영업 담당자 유효성 검사

    //PM_CS_APP_19.1.2 유효성 검사 결과 확인
        //PM_CS_APP_19.1.2.1 에러에 값 존재 시 에러 메시지 출력

    //PM_CS_APP_19.1.3 발주 다중 수정
        //PM_CS_APP_19.1.3.1 다중 수정 결과 확인
		if (service.updatePurchases(PurchaseVOs)==0) {
            //PM_CS_APP_19.1.3.1 값이 0 일경우 badRequest 리턴			
			return ResponseEntity.badRequest().build();
		}

    //PM_CS_APP_19.1.4 정상 처리 결과 리턴		
		return ResponseEntity.ok().build();
	}
	
	//PM_CS_APP_20.1 발주 단일 삭제 Controller
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletePurchase(@PathVariable String id){
    //PM_CS_APP_20.1.1 발주 코드 유효성 검사
		
    //PM_CS_APP_20.1.2 유효성 검사 결과 확인
        //PM_CS_APP_20.1.2.1 에러에 값 존재 시 에러 메시지 출력
		
    //PM_CS_APP_20.1.3 단일 수정 결과 확인
		if (service.deletePurchase(id) == 0) {
		//PM_CS_APP_20.1.3.1 값이 0 일경우 badRequest 리턴
			return ResponseEntity.badRequest().build();
		}
    
	//PM_CS_APP_20.1.4 정상 처리 결과 리턴
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping
	public ResponseEntity<String> deletePurchases(@RequestBody List<Map<String, String>> ids) {
		if (service.deletePurchases(ids) == 0) {
			// PM_CS_APP_20.1.3.1 값이 0 일경우 badRequest 리턴
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok().build();
	}
	

	
    //PM_CS_APP_22.1 발주 록록 조회  Controller
	@GetMapping
	public ResponseEntity<List<PmPurchaseVO>> getPurchaseList(PmPurchaseVO PurchaseVO){
		System.out.println(PurchaseVO.toString());
        //PM_CS_APP_22.1.1 유효성 검사
        //PM_CS_APP_22.1.1.1 배송 담당자 존재하는 지확인
        //PM_CS_APP_22.1.1.2 영업 담당자가 존재하는지 확인
        //PM_CS_APP_22.1.1.3 발주 상태가 옮바른지 확인
        //PM_CS_APP_22.1.1.4 배송 유형이 옮바른지 확인
		//PM_CS_APP_22.1.1.5 페이징 정보가 옮바른지 확인
		//PM_CS_APP_22.1.1.6 정렬 정보가 옮바른지 확인

        //PM_CS_APP_22.1.2 유효성 검사 결과 확인
        //PM_CS_APP_22.1.2.1 에러에 값 존재 시 에러 메시지 출력
			//PM_CS_APP_22.1.3 단일 수정 결과 확인
		List<PmPurchaseVO> PurchaseVOs = service.getPurchaseList(PurchaseVO);
		if (PurchaseVOs.isEmpty()) {
			//PM_CS_APP_22.1.3.1 값이 0 일경우 badRequest 리턴
			return ResponseEntity.badRequest().build();
		}
        return ResponseEntity.ok(PurchaseVOs);
        
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PmPurchaseVO> getPurchase(@PathVariable String id){
		PmPurchaseVO PurchaseVO = service.getPurchase(id);
		if (PurchaseVO.equals(null)) {
			return ResponseEntity.badRequest().build();
		}
        return ResponseEntity.ok(PurchaseVO);
        
	}
}
