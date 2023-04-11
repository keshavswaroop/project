package com.spring.mavenproject;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
  public static void main(String[] args) {
    demo1();
//	  demo2();
	  
//	  demo3();
	  
//	  demo4();
  }
  
  private static void demo4() {
	ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("com/spring/mavenproject/springconfig4.xml");
	EmployeeDAO emp1=(EmployeeDAO) ctx.getBean("empdao");
	System.out.println(emp1);
	
}

private static void demo3() {
	  ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("com/spring/mavenproject/springconfig2.xml");
	  Computer c1=(Computer) ctx.getBean("homecomputer");
	  System.out.println(c1);
	  
	  Computer c2=(Computer) ctx.getBean("officecomputer");
	  System.out.println(c2);
}

private static void demo2() {
	  ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("com/spring/mavenproject/springconfig2.xml");
	  Car c1=(Car) ctx.getBean("car");
	  System.out.println(c1.hashCode());
	  Car c2=(Car) ctx.getBean("car");
	  System.out.println(c2.hashCode());
	  
	  Object b1=ctx.getBean("bank");
	  System.out.println(b1.hashCode());
	  
	  Object b2=ctx.getBean("bank");
	  System.out.println(b2.hashCode());
			  
  }

private static void demo1() {
	System.out.println("Hello World!");
    
    //create the spring container
    AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(SpringConfig.class);
    //ask the container for employee bean
    Employee emp1=(Employee) ctx.getBean("emp1");
    System.out.println(emp1);
    Employee emp2=(Employee) ctx.getBean("emp2");
    System.out.println(emp2);
    Employee emp3=(Employee) ctx.getBean("emp3");
    System.out.println(emp3);
    
    Employee emp4=(Employee) ctx.getBean("emp4");
    System.out.println(emp4);
    Employee emp5=(Employee) ctx.getBean("emp5");
    System.out.println(emp5);
//    Employee emp6=(Employee) ctx.getBean("emp6");
//    System.out.println(emp6);
//    Employee emp7=(Employee) ctx.getBean("emp7");
//    System.out.println(emp7);
//    ShoppingCart item1=(ShoppingCart) ctx.getBean("item1");
//    System.out.println(item1);
}
}
