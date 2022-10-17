package com.webapp.constants;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonConstants {
	
	
	// Get the date in format defined
	static SimpleDateFormat sdate = new SimpleDateFormat("yyyy-MM-dd");

			// Get the date in string format

	public static final String CURRENT_STR_DATE = sdate.format(new Date());
	
	public static final Date CURRENT_DATE = new Date();
			

	
	
	

}
