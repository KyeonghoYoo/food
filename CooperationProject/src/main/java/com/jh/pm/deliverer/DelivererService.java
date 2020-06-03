package com.jh.pm.deliverer;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DelivererService {
	
	@Autowired DelivererDAO delivererDAO;

	public int insertDeliverer(DelivererVO delivererVO) {
		return delivererDAO.insertDeliverer(delivererVO);
	}

	public int updateDeliverer(DelivererVO delivererVO) {
		return delivererDAO.updateDeliverer(delivererVO);
	}

	public int deleteDeliverer(String id) {
		return delivererDAO.deleteDeliverer(id);
	}

	public DelivererVO getDeliverer(String id) {
		return delivererDAO.getDeliverer(id);
	}

	public List<DelivererVO> getDelivererList(DelivererVO delivererVO) {
		return delivererDAO.getDelivererList(delivererVO);
	}

	public int updateDeliverers(List<DelivererVO> delivererVOs) {
		for (DelivererVO delivererVO : delivererVOs) {
			if (delivererDAO.updateDeliverer(delivererVO) == 0) {
				return 0;
			}
		}
		return 1;
	}

	public int deleteDeliverers(List<Map<String, String>> ids) {
		for (Map<String, String> id : ids) {
			if (delivererDAO.deleteDeliverer(id.get("id")) == 0) {
				return 0;
			}
		}
		return 1;
	}

}
