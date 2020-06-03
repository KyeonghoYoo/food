package com.jh.cd.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class DateUtil {
	private int cYear;
	private int cMonth;
	private int cDay;
	private Calendar calendar;
	public DateUtil() {
		calendar = new GregorianCalendar(Locale.KOREA);
		cYear = calendar.get(Calendar.YEAR);
		cMonth = calendar.get(Calendar.MONTH);
		cDay = calendar.get(Calendar.DAY_OF_MONTH);
	}
	
	public String getCurrentDate() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String date = format.format(new Date());
		return date;
	}
	
	public String getOrderDate() {
		SimpleDateFormat format = new SimpleDateFormat("MMddyyyy");
		String date = format.format(new Date());
		return date;
	}
}
