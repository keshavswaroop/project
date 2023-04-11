package com.example.sportyShoes.repository;

import java.util.Optional;


import org.springframework.data.repository.CrudRepository;
import com.example.sportyShoes.entity.ShoeCategory;

public interface AdminCategoryRepository extends CrudRepository<ShoeCategory, Integer> {

	Optional<ShoeCategory> findByName(String category);

//	@Query("SELECT id , name FROM ShoeCategory WHERE name = :name")
//	ShoeCategory findByCategoryName( String name);
}
