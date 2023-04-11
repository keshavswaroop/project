package com.examples.S03stereotypes.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Instructor {
	private int id;
	private String name;
	
	@Autowired
	private Address homeaddress;

	@Override
	public String toString() {
		return "Instructor [id=" + id + ", name=" + name + ", homeaddress=" + homeaddress + "]";
	}
	
}
