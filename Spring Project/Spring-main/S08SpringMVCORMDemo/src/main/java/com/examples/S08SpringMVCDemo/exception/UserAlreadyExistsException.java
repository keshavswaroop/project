package com.examples.S08SpringMVCDemo.exception;

public class UserAlreadyExistsException  extends Exception{

	private static final long serialVersionUID = 1L;

	public UserAlreadyExistsException(String email) {
		super("user already exists");
	}
}
