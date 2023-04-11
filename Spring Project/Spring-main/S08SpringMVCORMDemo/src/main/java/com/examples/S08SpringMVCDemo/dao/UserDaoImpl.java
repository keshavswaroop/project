package com.examples.S08SpringMVCDemo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.examples.S08SpringMVCDemo.entity.User;

@Repository
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public int create(User user) {
		int result = (Integer) hibernateTemplate.save(user);
		return result;
	}

	public List<User> listUser() {
	
		return hibernateTemplate.loadAll(User.class);
	}

	public User findUser(String email) {
		User result = null;
		List<?> users = hibernateTemplate.find("from User u where u.email=?0", email);
		if(users!=null && users.size()>0) {
			result =(User) users.get(0);
		}
		return result;
	}
	
}
