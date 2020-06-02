package com.chahatg.day13.spring.javabased;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
@Lazy
public class AppConfiguration2 {
	
	@Bean(name="B3Service")
	public MessageService3 B3Service() {
		return new B3Service();	}
	@Bean
	public MessageInterfaceImpl3 messageInterfaceImpl3() {
		return new MessageInterfaceImpl3();
	}
}
