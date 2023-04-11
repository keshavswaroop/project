package com.examples.S05SpringJdbcDemo.dao;

import java.util.List;

import com.examples.S05SpringJdbcDemo.entity.Employee;

public interface EmployeeDAO {
	int create(Employee employee);
	int update(Employee employee);
	int delete(int id);
	List<Employee> read();
}
