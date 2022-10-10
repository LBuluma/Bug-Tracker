package com.webapp.component;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordClass {
	
	
	public static void main(String[] args) {
		PasswordClass passC = new PasswordClass();
		passC.encoderM();
		
	}
	// Create an encoder with strength 16
	private void encoderM() {
	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);
	String result = encoder.encode("joe@gmail.com");
	System.out.println(result);
//	System.out.print(encoder.matches("myPassword", result));
	}
	
	private void nDate() {
		
		
		SimpleDateFormat sdate = new SimpleDateFormat("yyyy-MM-dd");
		String date = sdate.format(new Date());
		System.out.print(date);
		
	}
	
	
	
}
