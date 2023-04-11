package com.examples.S08SpringMVCDemo.dao;

import java.util.List;

import com.examples.S08SpringMVCDemo.entity.User;

public interface UserDao {
	int create(User user);
	
	List<User> listUser();
	
	User findUser(String email);
}
