package com.jh.pm.item;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jh.common.CommonObejcMapper;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/items")
@Transactional
public class PmItemController {

	@Autowired PmItemValidator itemValidator;
	@Autowired PmItemService itemService;
	ObjectMapper objectMapper = new CommonObejcMapper().getObjectMapper();

	//핫픽스용(경호2019-05-08)
	@Autowired PmItemDAO itemDAO;
	
	// 아이템단일 삽입 
	@PostMapping
	public ResponseEntity<String> insertItem(PmItemVO itemVO, Errors errors) throws Exception {
		itemValidator.insertAndUpateItemValidator(itemVO, errors);

		if (errors.hasErrors())
			return ResponseEntity.badRequest()
					.body(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(errors));

		itemService.insertItem(itemVO);
		return ResponseEntity.ok().build();
	}

	// 아이템 조회
	@GetMapping
	@ResponseBody
	public ResponseEntity selectListItem(PmItemVO itemVO, Errors errors) throws JsonProcessingException {
		itemValidator.selectListItemValidator(itemVO, errors);

		if (errors.hasErrors())
			return ResponseEntity.badRequest()
					.body(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(errors));

		RowBounds bounds = new RowBounds(itemVO.getOffset(), itemVO.getLimit());

		return new ResponseEntity<List<PmItemVO>>(itemService.selectListItem(itemVO, bounds), HttpStatus.OK);
	}

	// 아이템 단일 조회
	/*
	@GetMapping("/{id}")
	public ResponseEntity selectOneItem(@PathVariable String id, Errors errors) throws JsonProcessingException {

		PmItemVO itemVO = itemValidator.selectOneItemValidator(id, errors);

		if (errors.hasErrors())
			return ResponseEntity.badRequest()
					.body(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(errors));

		PmSelectOneItemVO selectOneItemVO = itemService.selectOneItem(itemVO, errors);

		return new ResponseEntity<PmSelectOneItemVO>(selectOneItemVO, HttpStatus.OK);
	}
	*/
	// 아이템 단일 조회 핫픽스 2019-05-08
	@GetMapping("/{id}")
	public ResponseEntity<PmSelectOneItemVO> selectOneItem(@PathVariable String id) {

		
		PmItemVO itemVO = itemDAO.selectOneItem(id);

		PmSelectOneItemVO selectOneItemVO = itemService.selectOneItem(itemVO, null);

		return ResponseEntity.ok(selectOneItemVO);
	}
	
	// 아이템 단일 수정
	@PostMapping("/{id}")
	public ResponseEntity<String> updateOneItem(PmItemVO itemVO, Errors errors) throws JsonProcessingException {

		itemValidator.insertAndUpateItemValidator(itemVO, errors);

		if (errors.hasErrors())
			return ResponseEntity.badRequest()
					.body(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(errors));

		itemValidator.selectOneItemValidator(itemVO.getId(), errors);
		if (errors.hasErrors())
			return ResponseEntity.badRequest()
					.body(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(errors));

		itemService.updateOneItem(itemVO);

		return ResponseEntity.ok().build();
	}

	// 아이템 단일 삭제
	/*
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteOneItem(@PathVariable String id, Errors errors) throws JsonProcessingException {

		itemValidator.selectOneItemValidator(id, errors);
		if (errors.hasErrors())
			return ResponseEntity.badRequest()
					.body(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(errors));

		itemService.deleteOneItem(id);
		return ResponseEntity.ok().build();
	}
	*/
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteOneItem(@PathVariable String id) {

		//itemValidator.selectOneItemValidator(id, null);
		
		itemService.deleteOneItem(id);
		return ResponseEntity.ok().build();
	}
	
	// 아이템 다중 수정
	@PutMapping
	@ResponseBody
	public ResponseEntity<String> updateItemList(@RequestBody PmItemVOList itemVOs) {
		itemService.updateItemList(itemVOs.getItemVOs());
		return ResponseEntity.ok().build();
	}

	// 아이템 단일 삭제
	@DeleteMapping
	@ResponseBody
	public ResponseEntity<String> deleteItemLisT(@RequestBody PmDeleteItemIdList ids) {
		itemService.deleteItemLisT(ids.getIds());
		return ResponseEntity.ok().build();
	}
}