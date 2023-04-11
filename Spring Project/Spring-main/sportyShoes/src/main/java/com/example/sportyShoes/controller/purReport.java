package com.example.sportyShoes.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.sportyShoes.entity.Purchase;
import com.example.sportyShoes.entity.ShoeCategory;
import com.example.sportyShoes.repository.AdminCategoryRepository;
import com.example.sportyShoes.repository.PurchaseDetailsRepository;

@Controller
public class purReport {
	
	@Autowired
	private PurchaseDetailsRepository pdr;
	
	@Autowired
	private AdminCategoryRepository acr;
	
	@RequestMapping("/purchasereport")
	public String listPurchase(ModelMap model) {
		List<ShoeCategory> category= (List<ShoeCategory>) acr.findAll();
		List<Purchase> purchase = (List<Purchase>) pdr.findAll();
		model.addAttribute("purchases",purchase);
		
		Set<LocalDate> date1 = new HashSet<>();
		for(Purchase pur: purchase) {
			date1.add(pur.getDate());
		}
		model.addAttribute("date1",date1);
		model.addAttribute("category",category);
		return "purchaseDetailsHome";
	}
	
	
	@PostMapping
	@RequestMapping("/filterPurchase")
	public String filterPurchase(@RequestParam("date") String date, @RequestParam("category") String category1,ModelMap model) {
		System.out.println("--------------------------------"+date);
		List<ShoeCategory> category= (List<ShoeCategory>) acr.findAll();
		
		List<Purchase> purchase1 = new ArrayList<>();
		List<Purchase> purchase2 = new ArrayList<>();
		List<Purchase> purchase = new ArrayList<>();
		if(date.equals("all")) {
			purchase1 = (List<Purchase>) pdr.findAll();
			
		}
		else {
			DateTimeFormatter formatter= DateTimeFormatter.ofPattern("yyy-MM-dd");
			LocalDate localDate=LocalDate.parse(date,formatter);
			purchase1 = (List<Purchase>) pdr.findByDate(localDate);
			
		}
		
		if(category1.equals("all")) {
			purchase2 = (List<Purchase>) pdr.findAll();
			
		}
		else {
			
			Optional<ShoeCategory> category2 = acr.findByName(category1);
			ShoeCategory category3 = category2.get();
			purchase2 = (List<Purchase>) pdr.findByCategory(category3);
			
		}
		
		for(Purchase pur1: purchase1) {
			for(Purchase pur2: purchase2) {
				if(pur1.equals(pur2)) {
					purchase.add(pur1);
				}
			}
		}
		
		List<Purchase> h1 = (List<Purchase>) pdr.findAll();
		
		Set<LocalDate> date1 = new HashSet<>();
		for(Purchase pur: h1) {
			date1.add(pur.getDate());
		}
		model.addAttribute("date1",date1);
		model.addAttribute("category",category);
		model.addAttribute("purchases",purchase);
		return "purchaseDetailsHome";
		
	}
}
