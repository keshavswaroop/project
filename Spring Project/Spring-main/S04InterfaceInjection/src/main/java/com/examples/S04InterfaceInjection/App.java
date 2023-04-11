package com.examples.S04InterfaceInjection;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.examples.S04InterfaceInjection.service.OrderService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/examples/S04InterfaceInjection/springconfig4.xml");
        OrderService orderService = (OrderService) ctx.getBean("orderservice");
        orderService.placeOrder();
    }
}
