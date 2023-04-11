package com.examples.S05SpringJdbcDemo;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.examples.S05SpringJdbcDemo.dao.EmployeeDAO;
import com.examples.S05SpringJdbcDemo.entity.Employee;


public class App 
{
    public static void main( String[] args )
    {
        System.out.println("JDBC template demo");
        
        ClassPathXmlApplicationContext ctx= new ClassPathXmlApplicationContext("com/examples/S05SpringJdbcDemo/springconfig4.xml");
        
        EmployeeDAO employeeDao = (EmployeeDAO) ctx.getBean("employeedao");
        
//        Employee emp=new Employee();
//        emp.setId(2);
//        emp.setFirstName("John");
//        emp.setLastName("Smith");
//        
//        employeeDao.create(emp);
//        
//        Employee emp3=new Employee();
//        emp.setId(3);
//        emp.setFirstName("John");
//        emp.setLastName("Smith");
//        
//        employeeDao.create(emp3);
//        
//        Employee emp4=new Employee();
//        emp.setId(3);
//        emp.setFirstName("Jack");
//        emp.setLastName("Smith");
//        
//        employeeDao.update(emp4);
// 
//        Employee emp5=new Employee();
//        emp.setId(3);
//        emp.setFirstName("John");
//        emp.setLastName("Smith");
//        Employee emp1=new Employee();
//        
//        
//        employeeDao.delete(1);
        
        List<Employee> emp=employeeDao.read();
        System.out.println(emp);
        
    }
}
