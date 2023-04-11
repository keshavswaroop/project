package com.examples.S08SpringMVCDemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.examples.S08SpringMVCDemo.dao.UserDao;
import com.examples.S08SpringMVCDemo.entity.User;
import com.examples.S08SpringMVCDemo.exception.UserAlreadyExistsException;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userdao;

	
	@Transactional
	public int save(User user) throws UserAlreadyExistsException {
		if(userdao.findUser(user.getEmail())!=null) {
			throw new UserAlreadyExistsException(user.getEmail());
		}
		return userdao.create(user);
	}


	public List<User> getUsers() {
		
		return userdao.listUser();
	}
	
	
}
