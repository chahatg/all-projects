package com.chahatg.day13.spring.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class MessageInterfaceImpl2 {
	private MessageService2 msgService;
		
	@Autowired
	@Qualifier("B2Service")
	public void setMsgService(MessageService2 msgService) {
		this.msgService = msgService;
	}
	
	public void printMsg(String msg) {
		msgService.deliverMsg(msg);
	}
}
