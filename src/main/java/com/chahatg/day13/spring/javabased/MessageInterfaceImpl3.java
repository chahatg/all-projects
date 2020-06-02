package com.chahatg.day13.spring.javabased;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class MessageInterfaceImpl3 {
	private MessageService3 msgService;
		
	@Autowired
	@Qualifier("B3Service")
	public void setMsgService(MessageService3 msgService) {
		this.msgService = msgService;
	}
	
	public void printMsg(String msg) {
		msgService.deliverMsg(msg);
	}
}
