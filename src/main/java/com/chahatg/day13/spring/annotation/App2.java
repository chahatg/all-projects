package com.chahatg.day13.spring.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


public class App2 {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);
		MessageInterfaceImpl2 messenger = context.getBean(MessageInterfaceImpl2.class);
		messenger.printMsg("Hello World  - Annotation config");
	}
}
