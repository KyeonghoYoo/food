package com.jh.pm.category;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class CategoryDAO {

	@Autowired
	SqlSessionTemplate template;
	
	public int insertFirstCategory(CategoryVO vo) {
		return template.insert("CategoryDAO.insertFirstCategory", vo);
	}  
    public int insertSecondCategory(CategoryVO vo) {
		return template.insert("CategoryDAO.insertSecondCategory", vo);
	}
    public int insertThirdCategory(CategoryVO vo) {
		return template.insert("CategoryDAO.insertThirdCategory", vo);
	}

	public List<FirstCategoryVO> getFirstCategory(CategoryVO categoryVO) {
		return template.selectList("CategoryDAO.getFirstCategory", categoryVO);
	}
	public List<SecondCategoryVO> getSecondCategory(CategoryVO categoryVO) {
		return template.selectList("CategoryDAO.getSecondCategory", categoryVO);
	}
	public List<ThirdCategoryVO> getThirdCategory(CategoryVO categoryVO) {
		return template.selectList("CategoryDAO.getThirdCategory", categoryVO);
	}

	public int updateFirstCategory(CategoryVO vo) {
		return template.update("CategoryDAO.updateFirstCategory", vo);
	}
	public int updateSecondCategory(CategoryVO vo) {
		return template.update("CategoryDAO.updateSecondCategory", vo);
	}
	public int updateThirdCategory(CategoryVO vo) {
		return template.update("CategoryDAO.updateThirdCategory", vo);
	}

	public int updateFirstCategorySequence(FirstCategoryVO firstCategoryVO) {
		return template.update("CategoryDAO.updateFirstCategorySequence", firstCategoryVO);
	}
	public int updateSecondCategorySequence(SecondCategoryVO secondCategoryVO) {
		return template.update("CategoryDAO.updateSecondCategorySequence", secondCategoryVO);
	}
	public int updateThirdCategorySequence(ThirdCategoryVO thirdCategoryVO) {
		return template.update("CategoryDAO.updateThirdCategorySequence", thirdCategoryVO);
	}
	
	public int deleteFirstCategory(CategoryVO vo) {
		return template.delete("CategoryDAO.deleteFirstCategory", vo);
	}
	public int deleteSecondCategory(CategoryVO vo) {
		return template.delete("CategoryDAO.deleteSecondCategory", vo);
	}
	public int deleteThirdCategory(CategoryVO vo) {
		return template.delete("CategoryDAO.deleteThirdCategory", vo);
	}
	
}
