package com.example.S10SpringBootDemo.dao;

import org.springframework.stereotype.Component;

@Component
public class SomeDao {
	public void hello() {
		System.out.println("Hello from dao");
	}
}
