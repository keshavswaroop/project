package com.example.sportyShoes.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.sportyShoes.entity.Purchase;
import com.example.sportyShoes.entity.ShoeCategory;


public interface PurchaseDetailsRepository extends CrudRepository<Purchase, Integer> {

	List<Purchase> findByDate(LocalDate date);

	List<Purchase> findByCategory(ShoeCategory category3);
	
}
