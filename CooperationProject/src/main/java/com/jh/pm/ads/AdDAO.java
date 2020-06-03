package com.jh.pm.ads;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AdDAO {
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	public int insertAd(AdVO ad) {
		sqlSessionTemplate.insert("AdDAO.insertAd",ad);
		return ad.getAdID();
	}
	public List<AdVO> getAdList(RowBounds rowBounds) {
		AdVO adVO = new AdVO();
		return sqlSessionTemplate.selectList("AdDAO.getAdList", adVO,rowBounds);
	}
}
