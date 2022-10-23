package com.webapp.commonfunctions;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class CommonUserFMethods {
	
	public static Date convertToDate(String dateInString) throws ParseException {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
		return format.parse(dateInString);
	
	}
	
	public static String convertDateToString(Date date) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");  	  
		return dateFormat.format(date);
	}
	
	public static String convertIntToString(int intToConvert) {
		return String.valueOf(intToConvert);
	}

}
