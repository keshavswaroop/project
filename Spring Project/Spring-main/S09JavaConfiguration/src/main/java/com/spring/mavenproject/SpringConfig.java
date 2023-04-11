package com.spring.mavenproject;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
	
	@Bean
	public Employee emp1() {
		Employee emp = new Employee();
		emp.setId(1);
		emp.setName("John");
		return emp;
	}
	
	@Bean
	public Employee emp2() {
		Employee emp = new Employee();
		emp.setId(2);
		emp.setName("John");
		return emp;
	}
	
	@Bean
	public Employee emp3() {
		Employee emp = new Employee();
		emp.setId(3);
		emp.setName("John");
		return emp;
	}
	
	@Bean
	public Employee emp4() {
		Employee emp = new Employee();
		emp.setId(4);
		emp.setName("John");
		List<String> departments = new ArrayList<>();
		departments.add("HR");
		departments.add("Admin");
		departments.add("User");
		return emp;
	}
	
	@Bean
	public Employee emp5() {
		Employee emp = new Employee();
		emp.setId(5);
		emp.setName("John");
		Address address = new Address();
		address.setCity("Chennai");
		address.setState("TN");
		address.setPincode("384394");
		emp.setAddress(address);
		return emp;
	}
}
