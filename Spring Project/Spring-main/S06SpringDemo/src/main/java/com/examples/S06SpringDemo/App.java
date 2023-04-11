package com.examples.S06SpringDemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.examples.S06SpringDemo.dao.ProductDao;
import com.examples.S06SpringDemo.entity.Product;

import java.util.List;

public class App {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				"com/examples/S06SpringDemo/springconfig4.xml");

//		ProductDao productDao = (ProductDao) ctx.getBean("productdao");
//
//		List<Product> productsList= productDao.findAll();
		
		insert();
		
	}
	
	private static void delete() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				"com/examples/S06SpringDemo/springconfig4.xml");
		
		ProductDao productDao = (ProductDao) ctx.getBean("productdao");
		Product product = new Product();
		product.setId(2);
		
		productDao.delete(product);
		System.out.println("Product deleted");
		
	}
	private static void update() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				"com/examples/S06SpringDemo/springconfig4.xml");
		
		ProductDao productDao=(ProductDao) ctx.getBean("productdao");
		Product product = new Product();
		product.setId(2);
		product.setName("Jack");
		product.setDescription("John");
		product.setPrice(23);
		productDao.update(product);
	}
	
	private static void insert() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				"com/examples/S06SpringDemo/springconfig4.xml");
		
		ProductDao productDao=(ProductDao) ctx.getBean("productdao");
		Product product = new Product();
		product.setId(7);
		product.setName("Hi");
		product.setDescription("How");
		product.setPrice(23);
		productDao.create(product);
	}
}
