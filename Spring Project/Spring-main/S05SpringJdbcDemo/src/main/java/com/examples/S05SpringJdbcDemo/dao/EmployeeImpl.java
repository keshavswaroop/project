package com.examples.S05SpringJdbcDemo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.examples.S05SpringJdbcDemo.entity.Employee;
import com.examples.S05SpringJdbcDemo.rowmapper.EmployeeRowMapper;

@Component("employeedao")
public class EmployeeImpl implements EmployeeDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int create(Employee employee) {
		String sql = "insert into employee values(?,?,?)";
		int result = jdbcTemplate.update(sql, employee.getId(),employee.getFirstName(),employee.getLastName());
		System.out.println("Number of records inserted : " + result);
		return 0;
	}
 
	public int update(Employee employee) {
		String sql = "insert into employee values(?,?,?)";
		int result = jdbcTemplate.update(sql, employee.getId(),employee.getFirstName(),employee.getLastName());
		System.out.println("Number of records inserted : " + result);
		return 0;
	}

	public int delete(int id) {
		String sql="DELETE FROM employee WHERE id=?";
		int result=jdbcTemplate.update(sql,id);
		System.out.println(result);
		return id;

	}

	public List<Employee> read() {
		String sql="Select * from employee ";
		EmployeeRowMapper employeeRowMapper = new EmployeeRowMapper();
		List<Employee> employee = jdbcTemplate.query(sql, employeeRowMapper);
		return employee;
	}

}
