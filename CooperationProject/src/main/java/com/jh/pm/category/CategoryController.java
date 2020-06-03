package com.jh.pm.category;

import java.util.List;

import javax.validation.Valid;

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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jh.common.CommonObejcMapper;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/categories")
public class CategoryController {
	
	@Autowired CategoryService service;
	@Autowired CategoryValidator categoryValidator;

	ObjectMapper objectMapper = new CommonObejcMapper().getObjectMapper();

	@PostMapping
	public ResponseEntity<String> insertCategory(@RequestBody @Valid CategoryVO vo, Errors errors) throws Exception {
		if (errors.hasErrors())
			return ResponseEntity.badRequest().body(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(errors));
		
		categoryValidator.insertValidate(vo, errors);
		
		if (errors.hasErrors())
			return ResponseEntity.badRequest().body(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(errors));
		
		service.insertCategory(vo);
		return ResponseEntity.ok().build();
	}

	@GetMapping
	public SelectCategory getCategoryAll(SelectCategory selectCategory) {
		return service.getCategoryAll(selectCategory);
	}
	
	@GetMapping(value="/{parentCategoryId}/level/{categoriesLevel}")
	public List getCategoryList(CategoryVO categoryVO) {
		return service.getCategoryList(categoryVO);
	}

	@PutMapping(value="/{categoryId}/level/{categoriesLevel}")
	public ResponseEntity<String> updateCategory(
			@PathVariable(name="categoryId") int categoryId,
			@PathVariable(name="categoriesLevel") int categoriesLevel,
			@RequestBody @Valid CategoryVO vo, Errors errors)	throws Exception {
		if (errors.hasErrors())
			return ResponseEntity.badRequest().body(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(errors));
		
		categoryValidator.updateValidate(vo, errors);
		
		if (errors.hasErrors()) 	 
			return ResponseEntity.badRequest().body(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(errors));
		service.updateCategory(categoryId, categoriesLevel, vo);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping(value="/{categoryID}/level/{categoriesLevel}")
	public ResponseEntity<String> deleteCategory(CategoryVO vo,Errors errors) throws JsonProcessingException{
		
		categoryValidator.updateValidate(vo, errors);
		if (errors.hasErrors()) 	 
			return ResponseEntity.badRequest().body(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(errors));
		service.deleteCategory(vo);
		return ResponseEntity.ok().build();
	}
}
