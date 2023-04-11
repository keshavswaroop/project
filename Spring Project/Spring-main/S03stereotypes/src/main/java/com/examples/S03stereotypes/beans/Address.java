package com.examples.S03stereotypes.beans;

import org.springframework.stereotype.Component;

@Component
public class Address {
	private String city;
	private String state;
	private String pincode;
	
	@Override
	public String toString() {
		return "Address [city=" + city + ", state=" + state + ", pincode=" + pincode + "]";
	}
}
