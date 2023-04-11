package com.examples.S04InterfaceInjection.dao;

import org.springframework.stereotype.Component;

@Component("orderdaomysql")
public class OrderDAOImpl implements OrderDAO {

	public void createOrder() {
		System.out.println("Open connection to MySQL");
		
	}
	
}
