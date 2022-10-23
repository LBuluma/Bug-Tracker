package com.webapp.compapplication;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.webapp.component.MathComponent;

public class ComponentTest {

	public static void main(String[] args) {
		System.out.println("ComponentTest.main: IN");
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.webapp.component");
		context.refresh();
		
		System.out.println("context.main: IN"+context);

		MathComponent ms = context.getBean(MathComponent.class);

		double result = ms.add(1, 2);
		System.out.println("Addition of 1 and 2 = " + result);

		context.close();
		System.out.println("context.main: OUT");
	}
}
