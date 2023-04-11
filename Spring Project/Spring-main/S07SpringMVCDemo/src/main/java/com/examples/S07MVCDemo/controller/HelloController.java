package com.examples.S07MVCDemo.controller;



import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.examples.S07MVCDemo.model.Employee;

@Controller
public class HelloController {
	
	@RequestMapping("hello")
	public ModelAndView hello() {
		ModelAndView modelView = new ModelAndView();
		modelView.addObject("id",123);
		modelView.addObject("name","Ken");
		modelView.addObject("salary",1000);
		modelView.setViewName("hello");
		return modelView;
		
		
	}
	
	@RequestMapping("readobject")
	public ModelAndView read2() {
		ModelAndView modelView = new ModelAndView();
		Employee emp=new Employee();
		emp.setId(12345);
		emp.setName("Marry");
		emp.setSalary(3456);
		modelView.addObject("employee",emp);
		modelView.setViewName("hello");
		return modelView;
		
		
	}
	@RequestMapping("employees")
	public ModelAndView read3() {
		
		ModelAndView modelView = new ModelAndView();
		List<Employee> employees = new ArrayList<Employee>();
		Employee emp=new Employee();
		emp.setId(12345);
		emp.setName("Marry");
		emp.setSalary(3456);
		employees.add(emp);
		
		Employee emp2=new Employee();
		emp.setId(123453);
		emp.setName("Marry2");
		emp.setSalary(345634);
		employees.add(emp2);
		modelView.addObject("employee",employees);
		
		modelView.setViewName("employees");
		return modelView;
		
		
	}
	
	@RequestMapping("/showdata")
	public ModelAndView showData(@RequestParam("id") int id,@RequestParam("name") String name) {
		System.out.println("Id = "+id);
		System.out.println("Name = "+name);
		ModelAndView mv=new ModelAndView();
		mv.addObject("id",id);
		mv.addObject("name",name);
		mv.setViewName("showdata");
		return mv;
	}
}
