package com.jh.pm.provider;

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
@RequestMapping("/providers")
@CrossOrigin(origins = "*")
public class PmProviderController {

	@Autowired
	PmProviderService pmProviderService;
	
	// CLASS_SELLING_PM_1.1 매입처 단일 삽입 Contorller
	@PostMapping
	public ResponseEntity<String> insertPmProvider(@RequestBody PmProviderVO pmProviderVO) {
		// CLASS_SELLING_PM_1.1.1 pmProviderVO 유효성 검사

		// CLASS_SELLING_PM_1.1.2 pmProviderVO 데이터 삽입
		if (pmProviderService.insertPmProvider(pmProviderVO) == 0) {
			// CLASS_SELLING_PM_1.1.3매입처 단일 삽입 결과 확인
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok().build();
	}

	// CLASS_SELLING_PM_3.1 매입처 단일 수정 controller
	@PutMapping("/{id}")
	public ResponseEntity<String> updatePmProvider(@PathVariable(value="id") String id, @RequestBody PmProviderVO pmProviderVO) {
		
		// CLASS_SELLING_PM_3.1.1 pmProviderVO 유효성 검사

		pmProviderVO.setId(id);
		// CLASS_SELLING_PM_3.1.2 pmProviderVO 데이터 수정
		if (pmProviderService.updatePmProvider(pmProviderVO) == 0) {
			return ResponseEntity.badRequest().build();
		}
			
		// CLASS_SELLING_PM_1.1.3 매입처 단일 수정 결과 확인
		return ResponseEntity.ok().build();
	}
	
	//CLASS_SELLING_PM_5.1 매입처 북수 수정 controller
	@PutMapping
	public ResponseEntity<String> updatePmProviders(@RequestBody List<PmProviderVO> pmProviderVOs) {
		System.out.println(pmProviderVOs.toString());
	//CLASS_SELLING_PM_5.1.1 pmProviderVOs 유효성 검사
		
	//CLASS_SELLING_PM_5.1.2 pmProviderVOs 데이터 수정
		if(pmProviderService.updatePmProviders(pmProviderVOs) == 0) {
			return ResponseEntity.badRequest().build();
		}
		
	//CLASS_SELLING_PM_5.1.3 매입처 복수 수정 결과 전송
		return ResponseEntity.ok().build();
	}
	
	//CLASS_SELLING_PM_6.1 매입처 단일 삭제 controller
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletePmProvider(@PathVariable String id) {
		//CLASS_SELLING_PM_6.1.1 매입처 id 유효성 검사
		
		//CLASS_SELLING_PM_6.1.1 매입처 id 해당 된는 튜플 삭제
		if (pmProviderService.deletePmProvider(id) == 0) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok().build();
	}
	
	//CLASS_SELLING_PM_7.1 매입처 북수 수정 controller
		@DeleteMapping
		public ResponseEntity<String> deletePmProviders(@RequestBody List<Map<String, String>> ids) {
			
		//CLASS_SELLING_PM_7.1.2 ids 매입처 삭제
			if(pmProviderService.deletePmProviders(ids) == 0) {
				return ResponseEntity.badRequest().build();
			}
			
		//CLASS_SELLING_PM_7.1.2 다중 삭제 결과 반환
			return ResponseEntity.ok().build();
		}
		
	//CLASS_SELLING_PM_8.1 매입처 정보 조회 controller
		@GetMapping
		public ResponseEntity<List<PmProviderVO>> getPmProviders(PmProviderVO pmProviderVO){
			//CLASS_SELLING_PM_8.1.2 pmProviderVO 매입처 정보 조회
			List<PmProviderVO> ProviderVOs = pmProviderService.getPmProviders(pmProviderVO);
				//CLASS_SELLING_PM_8.1.2.1 조회한 데이터가 비워있는 경우
			if (ProviderVOs.isEmpty()) {
				return ResponseEntity.badRequest().build();
			}
			//CLASS_SELLING_PM_8.1.3 조회 결과 반환
			
			return ResponseEntity.ok(ProviderVOs);
		}
		
	//CLASS_SELLING_PM_8.1 매입처 정보 조회 controller
	@GetMapping("/{id}")
	public ResponseEntity<PmProviderVO> getPmProvider(@PathVariable String id){
		//CLASS_SELLING_PM_8.1.2 pmProviderVO 매입처 정보 조회
		PmProviderVO ProviderVO = pmProviderService.getPmProvider(id);
			//CLASS_SELLING_PM_8.1.2.1 조회한 데이터가 비워있는 경우
		if (ProviderVO.equals(null)) {
			return ResponseEntity.badRequest().build();
		}
		//CLASS_SELLING_PM_8.1.3 조회 결과 반환
		
		return ResponseEntity.ok(ProviderVO);
	}
		
}