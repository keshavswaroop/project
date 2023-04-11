package com.examples.S08SpringMVCDemo.service;

import java.util.List;

import com.examples.S08SpringMVCDemo.entity.User;
import com.examples.S08SpringMVCDemo.exception.UserAlreadyExistsException;

public interface UserService {
	int save(User user) throws UserAlreadyExistsException;
	
	List<User> getUsers();
}
