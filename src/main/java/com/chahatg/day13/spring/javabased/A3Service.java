package com.chahatg.day13.spring.javabased;

import org.springframework.stereotype.Service;


@Service("A3Service")
public class A3Service implements MessageService3{
	public void deliverMsg(String msg) {
		System.out.println("Message from A3 Service: " + msg);
	}
}
