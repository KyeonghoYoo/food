package com.jh.common;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class StringToDate {
	SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
	public Date stringToDate(String StringDate) throws Exception {	
		Date to = transFormat.parse(StringDate);
		return to; 
	} 
}
