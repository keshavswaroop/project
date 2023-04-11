package com.spring.mavenproject;

public class EmployeeDAO {
	private String dbserver;
	private String dbport;
	private String dbuser;
	private String dbpassword;
	public EmployeeDAO(String dbserver, String dbport, String dbuser, String dbpassword) {
		super();
		this.dbserver = dbserver;
		this.dbport = dbport;
		this.dbuser = dbuser;
		this.dbpassword = dbpassword;
	}
	@Override
	public String toString() {
		return "EmployeeDAO [dbserver=" + dbserver + ", dbport=" + dbport + ", dbuser=" + dbuser + ", dbpassword="
				+ dbpassword + "]";
	}
	
	public Employee getEmployee(int id) {
		//get db connection using 
		return null;
	}
}
