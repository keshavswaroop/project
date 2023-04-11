package com.example.sportyShoes.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.sportyShoes.entity.Admin;

public interface AdminLoginRepository extends CrudRepository<Admin, Integer> {
	
}
