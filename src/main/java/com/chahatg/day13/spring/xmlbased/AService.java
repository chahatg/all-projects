package com.chahatg.day13.spring.xmlbased;

public class AService implements MessageService{
	public void deliverMsg(String msg) {
		System.out.println("Message from A Service: " + msg);
	}
}
