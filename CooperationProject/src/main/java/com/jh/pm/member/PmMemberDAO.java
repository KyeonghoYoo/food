package com.jh.pm.member;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PmMemberDAO {

	@Autowired
	SqlSessionTemplate template;

	public int insertMember(PmMemberVO memberVO) {
		return template.insert("MemberDAO.insertMember", memberVO);
	}

	public int updateMember(PmMemberVO memberVO) {
		return template.update("MemberDAO.updateMember", memberVO);
	}

	public int deteleMember(String id) {
		return template.delete("MemberDAO.deleteMember", id);
	}

	public List<PmMemberVO> getMemberList() {
		return template.selectList("MemberDAO.getMemberList");
	}

	public PmMemberVO getMember(String id) {
		return template.selectOne("MemberDAO.getMember", id);		
	}
}
