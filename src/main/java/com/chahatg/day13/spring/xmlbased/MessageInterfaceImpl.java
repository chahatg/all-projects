package com.chahatg.day13.spring.xmlbased;

public class MessageInterfaceImpl implements MessageInterface {
	private MessageService msgService;
	
	public void setMsgService(MessageService msgService) {
		this.msgService = msgService;
	}

	public void printMsg(String msg) {
		msgService.deliverMsg(msg);
	}
}
