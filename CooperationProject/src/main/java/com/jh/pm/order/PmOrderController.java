package com.jh.pm.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
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
@RequestMapping("/orders")
@CrossOrigin(origins = "*")
public class PmOrderController {

	@Autowired PmOrderService service;
	@Autowired PmOrderValidator orderValidator;
	
	//PM_CS_APP_17.1 주문 단일 등록 Controller
	@PostMapping
	public ResponseEntity<String> insertOrder(@RequestBody PmOrderVO orderVO, Errors errors){
		
		//PM_CS_APP_17.1.1 거래처 유효성감사
		orderValidator.insertOrder(orderVO, errors);
		
		//PM_CS_APP_17.1.2유효성 검사 결과 확인
		if (errors.hasErrors()) {
			//PM_CS_APP_17.1.2.1 에러 메시지 리턴
		}
			
		//PM_CS_APP_17.1.3 주문 단일 등록
		if (service.insertOrder(orderVO) == 0) {
			return ResponseEntity.badRequest().build();
		}	
		//PM_CS_APP_17.1.4 정상 결과 리턴
		return ResponseEntity.ok().build();
	}	
	
	//PM_CS_APP_18.1 주문 단일 수정 controller
	@PutMapping("/{id}")
	public ResponseEntity<String> updateOrder(@PathVariable String id, @RequestBody PmOrderVO orderVO, Errors errors){
	    //PM_CS_APP_18.1.1 유효성 검사
	        //PM_CS_APP_18.1.1.1 해당 주문값지 존재한는 지 유효성 검사
	        //PM_CS_APP_18.1.1.2 배송 요청일자 유효성 검사
	        //PM_CS_APP_18.1.1.3 배송 담당자 유효성 검사
	        //PM_CS_APP_18.1.1.4 영업 담당자 유효성 검사
	
	    //PM_CS_APP_18.1.2 유효성 검사 결과 확인
	        //PM_CS_APP_18.1.2.1 에러에 값 존재 시 에러 메시지 출력
	
		orderVO.setId(id);
	    //PM_CS_APP_18.1.3 주문 단일 수정
			//PM_CS_APP_18.1.3.1 단일 수정 결과 확인
		if (service.updateOrder(orderVO)==0) {
			//PM_CS_APP_18.1.3.2 값이 0 일경우 badRequest 리턴
			return ResponseEntity.badRequest().build();
		}
	        
	    //PM_CS_APP_18.1.4 정상 처리 결과 리턴
		return ResponseEntity.ok().build();
	}
	
	//PM_CS_APP_19.1 주문 다중 수정 controller
	@PutMapping
	public ResponseEntity<String> updateOrders(@RequestBody List<PmOrderVO> orderVOs, Errors errors){
	    //PM_CS_APP_19.1.1 유효성 검사
        //PM_CS_APP_19.1.1.2 배송 요청일자 유효성 검사
        //PM_CS_APP_19.1.1.3 배송 담당자 유효성 검사
        //PM_CS_APP_19.1.1.4 영업 담당자 유효성 검사

    //PM_CS_APP_19.1.2 유효성 검사 결과 확인
        //PM_CS_APP_19.1.2.1 에러에 값 존재 시 에러 메시지 출력

    //PM_CS_APP_19.1.3 주문 다중 수정
        //PM_CS_APP_19.1.3.1 다중 수정 결과 확인
		if (service.updateOrders(orderVOs)==0) {
            //PM_CS_APP_19.1.3.1 값이 0 일경우 badRequest 리턴			
			return ResponseEntity.badRequest().build();
		}

    //PM_CS_APP_19.1.4 정상 처리 결과 리턴		
		return ResponseEntity.ok().build();
	}
	
	//PM_CS_APP_20.1 주문 단일 삭제 Controller
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteOrder(@PathVariable String id){
    //PM_CS_APP_20.1.1 주문 코드 유효성 검사
		
    //PM_CS_APP_20.1.2 유효성 검사 결과 확인
        //PM_CS_APP_20.1.2.1 에러에 값 존재 시 에러 메시지 출력
		
    //PM_CS_APP_20.1.3 단일 수정 결과 확인
		if (service.deleteOrder(id) == 0) {
		//PM_CS_APP_20.1.3.1 값이 0 일경우 badRequest 리턴
			return ResponseEntity.badRequest().build();
		}
    
	//PM_CS_APP_20.1.4 정상 처리 결과 리턴
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping
	public ResponseEntity<String> deleteOrders(@RequestBody List<String> ids) {
		if (service.deleteOrders(ids) == 0) {
			// PM_CS_APP_20.1.3.1 값이 0 일경우 badRequest 리턴
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok().build();
	}
	

	
    //PM_CS_APP_22.1 주문 록록 조회  Controller
	@GetMapping
	public ResponseEntity<List<PmOrderVO>> getOrderList(PmOrderVO orderVO){
		System.out.println(orderVO.toString());
        //PM_CS_APP_22.1.1 유효성 검사
        //PM_CS_APP_22.1.1.1 배송 담당자 존재하는 지확인
        //PM_CS_APP_22.1.1.2 영업 담당자가 존재하는지 확인
        //PM_CS_APP_22.1.1.3 주문 상태가 옮바른지 확인
        //PM_CS_APP_22.1.1.4 배송 유형이 옮바른지 확인
		//PM_CS_APP_22.1.1.5 페이징 정보가 옮바른지 확인
		//PM_CS_APP_22.1.1.6 정렬 정보가 옮바른지 확인

        //PM_CS_APP_22.1.2 유효성 검사 결과 확인
        //PM_CS_APP_22.1.2.1 에러에 값 존재 시 에러 메시지 출력
			//PM_CS_APP_22.1.3 단일 수정 결과 확인
		List<PmOrderVO> orderVOs = service.getOrderList(orderVO);
		if (orderVOs.isEmpty()) {
			//PM_CS_APP_22.1.3.1 값이 0 일경우 badRequest 리턴
			return ResponseEntity.badRequest().build();
		}
        return ResponseEntity.ok(orderVOs);
        
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PmOrderVO> getOrder(@PathVariable String id){
		PmOrderVO orderVO = service.getOrder(id);
		if (orderVO.equals(null)) {
			return ResponseEntity.badRequest().build();
		}
        return ResponseEntity.ok(orderVO);
        
	}
}
