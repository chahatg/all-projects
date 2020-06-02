package com.chahatg.day13.spring.javabased;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan("com.chahatg.spring.spring_practice3")
@Import(AppConfiguration2.class)
public class AppConfiguration {
	@Bean(name="A3Service")
	public MessageService3 A3Service() {
		return new A3Service();
	}
}
