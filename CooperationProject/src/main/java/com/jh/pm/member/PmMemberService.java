package com.jh.pm.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PmMemberService {
	
	@Autowired PmMemberDAO memberDAO;
	
	
	public int insertMember(PmMemberVO memberVO) {
		return memberDAO.insertMember(memberVO);
	}


	public int updateMember(PmMemberVO memberVO) {
		return memberDAO.updateMember(memberVO);
	}


	public int deleteMember(String id) {
		return memberDAO.deteleMember(id);
	}


	public List<PmMemberVO> getMemberList() {
		return memberDAO.getMemberList();
	}


	public PmMemberVO getMember(String id) {
		return memberDAO.getMember(id);
	}
}
