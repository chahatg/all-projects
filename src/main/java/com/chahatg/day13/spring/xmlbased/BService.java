package com.chahatg.day13.spring.xmlbased;

public class BService implements MessageService{
	public void deliverMsg(String msg) {
		System.out.println("Message from B Service: " + msg);
	}
}
