package com.examples.S02Autowiring;

import org.springframework.context.support.ClassPathXmlApplicationContext;


public class App {
  public static void main(String[] args) {
	  ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("com/examples/S02Autowiring/springconfig4.xml");
	  Employee c1=(Employee) ctx.getBean("emp1");
	  System.out.println(c1);
  }
}
