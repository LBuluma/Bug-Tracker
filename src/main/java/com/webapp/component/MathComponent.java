package com.webapp.component;

import org.springframework.stereotype.Component;

@Component
public class MathComponent {
	
	public MathComponent() {
		
	}
	
	public double add(double num1, double num2) {
		System.out.println("MathComponent.add: IN");
		return num1 + num2;
		
	}

}
