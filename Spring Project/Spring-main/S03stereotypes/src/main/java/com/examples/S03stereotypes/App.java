package com.examples.S03stereotypes;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.examples.S03stereotypes.beans.Instructor;

public class App {
  public static void main(String[] args) {
    ClassPathXmlApplicationContext ctx= new ClassPathXmlApplicationContext("com/examples/S03stereotypes/springconfig4.xml");
    Instructor in=(Instructor) ctx.getBean("instructor");
    System.out.print(in);
  }
}
