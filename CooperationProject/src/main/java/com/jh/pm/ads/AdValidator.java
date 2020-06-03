package com.jh.pm.ads;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import com.jh.common.StringToDate;

@Component
public class AdValidator {
	
	@Autowired
	StringToDate stringToDate;
	
	public void validate(AdVO ad, Errors errors) throws Exception {
	
			ad.setAdStartDate(stringToDate.stringToDate(ad.getAdStartDateString()));
			ad.setAdEndDate(stringToDate.stringToDate(ad.getAdEndDateString()));
		
		int dateCompare = ad.getAdStartDate().compareTo(ad.getAdEndDate());
		
		if(dateCompare >= 0) {
			errors.reject("wrongPrices StartDate", "StartDate Value wrong");
		}
		
	}
}
