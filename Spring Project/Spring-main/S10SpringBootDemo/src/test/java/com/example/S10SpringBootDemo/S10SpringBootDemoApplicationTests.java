package com.example.S10SpringBootDemo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import com.example.S10SpringBootDemo.Service.SomeService;

@SpringBootTest
class S10SpringBootDemoApplicationTests {
	
	@Autowired
	ApplicationContext context;
	

	@Test
	void contextLoads() {
		SomeService someService=context.getBean(SomeService.class);
		someService.create();
	}

}
