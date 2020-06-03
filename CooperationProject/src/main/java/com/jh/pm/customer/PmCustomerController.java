package com.jh.pm.customer;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customers")
@CrossOrigin(origins = "*")
public class PmCustomerController {

	@Autowired
	PmCustomerService pmCustomerService;

	// CLASS_SELLING_PM_1.1 거래처 단일 삽입 Contorller
	@PostMapping
	public ResponseEntity<String> insertPmCustomer(@RequestBody PmCustomerVO pmCustomerVO) {
		// CLASS_SELLING_PM_1.1.1 pmCustomerVO 유효성 검사

		// CLASS_SELLING_PM_1.1.2 pmCustomerVO 데이터 삽입
		if (pmCustomerService.insertPmCustomer(pmCustomerVO) == 0) {
			// CLASS_SELLING_PM_1.1.3거래처 단일 삽입 결과 확인
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok().build();
	}

	// CLASS_SELLING_PM_3.1 거래처 단일 수정 controller
	@PutMapping("/{id}")
	public ResponseEntity<String> updatePmCustomer(@PathVariable(value = "id") String id,
			@RequestBody PmCustomerVO pmCustomerVO) {

		// CLASS_SELLING_PM_3.1.1 pmCustomerVO 유효성 검사

		pmCustomerVO.setId(id);
		// CLASS_SELLING_PM_3.1.2 pmCustomerVO 데이터 수정
		if (pmCustomerService.updatePmCustomer(pmCustomerVO) == 0) {
			return ResponseEntity.badRequest().build();
		}

		// CLASS_SELLING_PM_1.1.3 거래처 단일 수정 결과 확인
		return ResponseEntity.ok().build();
	}

	// CLASS_SELLING_PM_5.1 거래처 북수 수정 controller
	@PutMapping
	public ResponseEntity<String> updatePmCustomers(@RequestBody List<PmCustomerVO> pmCustomerVOs) {
		System.out.println(pmCustomerVOs.toString());
		// CLASS_SELLING_PM_5.1.1 pmCustomerVOs 유효성 검사

		// CLASS_SELLING_PM_5.1.2 pmCustomerVOs 데이터 수정
		if (pmCustomerService.updatePmCustomers(pmCustomerVOs) == 0) {
			return ResponseEntity.badRequest().build();
		}

		// CLASS_SELLING_PM_5.1.3 거래처 복수 수정 결과 전송
		return ResponseEntity.ok().build();
	}

	// CLASS_SELLING_PM_6.1 거래처 단일 삭제 controller
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletePmCustomer(@PathVariable String id) {
		// CLASS_SELLING_PM_6.1.1 거래처 id 유효성 검사

		// CLASS_SELLING_PM_6.1.1 거래처 id 해당 된는 튜플 삭제
		if (pmCustomerService.deletePmCustomer(id) == 0) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok().build();
	}

	// CLASS_SELLING_PM_7.1 거래처 북수 수정 controller
	@DeleteMapping
	public ResponseEntity<String> deletePmCustomers(@RequestBody List<Map<String,String>> ids) {

		// CLASS_SELLING_PM_7.1.2 ids 거래처 삭제
		if (pmCustomerService.deletePmCustomers(ids) == 0) {
			return ResponseEntity.badRequest().build();
		}

		// CLASS_SELLING_PM_7.1.2 다중 삭제 결과 반환
		return ResponseEntity.ok().build();
	}

	// CLASS_SELLING_PM_8.1 거래처 정보 조회 controller
	@GetMapping
	public ResponseEntity<List<PmCustomerVO>> getPmCustomers(PmCustomerVO pmCustomerVO) {
		// CLASS_SELLING_PM_8.1.2 pmCustomerVO 거래처 정보 조회
		List<PmCustomerVO> customerVOs = pmCustomerService.getPmCustomers(pmCustomerVO);
		// CLASS_SELLING_PM_8.1.2.1 조회한 데이터가 비워있는 경우
		if (customerVOs.isEmpty()) {
			return ResponseEntity.badRequest().build();
		}
		// CLASS_SELLING_PM_8.1.3 조회 결과 반환

		return ResponseEntity.ok(customerVOs);
	}

	// CLASS_SELLING_PM_8.1 거래처 정보 조회 controller
	@GetMapping("/{id}")
	public ResponseEntity<PmCustomerVO> getPmCustomer(@PathVariable String id) {
		// CLASS_SELLING_PM_8.1.2 pmCustomerVO 거래처 정보 조회
		PmCustomerVO customerVO = pmCustomerService.getPmCustomer(id);
		// CLASS_SELLING_PM_8.1.2.1 조회한 데이터가 비워있는 경우
		if (customerVO.equals(null)) {
			return ResponseEntity.badRequest().build();
		}
		// CLASS_SELLING_PM_8.1.3 조회 결과 반환

		return ResponseEntity.ok(customerVO);
	}

}