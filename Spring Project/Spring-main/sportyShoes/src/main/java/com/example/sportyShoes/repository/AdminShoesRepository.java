package com.example.sportyShoes.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.sportyShoes.entity.Shoe;
import com.example.sportyShoes.entity.ShoeCategory;

public interface AdminShoesRepository extends CrudRepository<Shoe, Integer> {
	

	List<Shoe> getAllByOrderByPriceAsc();

	List<Shoe> getAllByOrderByPriceDesc();

	List<Shoe> findByCategory(ShoeCategory shoeCategory);





}
