package com.avinash;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
public class LocalServiceBean {
    
	@Profile("test")
	@Bean
	public String getService() {
		return "test Service";
	}
	
	@Profile("dev")
	@Bean
	public String getService1() {
		return "dev Service";
	}
}
