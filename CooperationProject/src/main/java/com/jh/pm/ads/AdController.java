package com.jh.pm.ads;

import java.util.List;

import javax.validation.Valid;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jh.common.StaicKeyWord;
import com.jh.common.UploadBiz;

@RestController
@RequestMapping("/ads")
public class AdController {

	@Autowired
	AdValidator adValidator;
	
	@Autowired
	AdDAO adDAO;
	
	RowBounds bounds;
	
	@Autowired
	UploadBiz uploadBiz;  

	@PostMapping
	@Transactional
	public ResponseEntity<String> insertAd(@Valid AdVO ad, Errors errors) throws Exception {
		if (errors.hasErrors()) return ResponseEntity.badRequest().body("입력 데이터가 부족합니다.");

		adValidator.validate(ad, errors);
		if (errors.hasErrors()) return ResponseEntity.badRequest().body("광고 시작일과 종료 일정이 잘못 되었습니다.");
		ad.update();
		uploadBiz.uploadAjaxPOST(ad.getAdImage(), adDAO.insertAd(ad), StaicKeyWord.AD_PATH);
		return new ResponseEntity(HttpStatus.OK);
	}
	
	@GetMapping
	public @ResponseBody List<AdVO> getEAdList(@RequestParam(required=false) int offset,@RequestParam(required=false) int limit) {
		bounds = new RowBounds(offset, limit);
		return adDAO.getAdList(bounds);
	}
	
//	@PutMapping("/{id}")
//	public ResponseEntity updateAd(@PathVariable Integer id,
//									@RequestBody @Valid AdVO ad,
//									Errors errors) {
//		
//		return null;
//	}
	

}

