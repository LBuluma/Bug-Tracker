package com.webapp.compapplication;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Test {
	//Method to provide the date for the end of month
	public static void main (String[] args) {
		String date = "02/02/2020";
		LocalDate convertedDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("M/d/yyyy"));
		convertedDate = convertedDate.withDayOfMonth(
		                                convertedDate.getMonth().length(convertedDate.isLeapYear()));
		System.out.println(convertedDate);
	}

}
