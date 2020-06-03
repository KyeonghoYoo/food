package com.jh.pm.member;

import java.util.List;

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
@RequestMapping("/members")
@CrossOrigin(origins = "*")
public class PmMemberController {

	@Autowired	PmMemberService service;
	
	@PostMapping
	public ResponseEntity<String> insertMember(@RequestBody PmMemberVO memberVO){
		
		if (service.insertMember(memberVO)==0) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> updateMember(@PathVariable String id, @RequestBody PmMemberVO memberVO){
		memberVO.setId(id);
		if (service.updateMember(memberVO)==0) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteMember(@PathVariable String id){
		if (service.deleteMember(id)==0) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok().build();
	}
	@GetMapping
	public ResponseEntity<List<PmMemberVO>> getMemberList(){
		List<PmMemberVO> memberVOs = service.getMemberList();
		return ResponseEntity.ok(memberVOs);
	}
	@GetMapping("/{id}")
	public ResponseEntity<PmMemberVO> getMember(@PathVariable String id){
		PmMemberVO memberVOs = service.getMember(id);
		return ResponseEntity.ok(memberVOs);
	}
}