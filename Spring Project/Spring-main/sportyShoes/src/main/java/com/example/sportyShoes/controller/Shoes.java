package com.example.sportyShoes.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.sportyShoes.entity.Shoe;
import com.example.sportyShoes.entity.ShoeCategory;
import com.example.sportyShoes.repository.AdminCategoryRepository;
import com.example.sportyShoes.repository.AdminShoesRepository;

@Controller
public class Shoes {
	@Autowired
	private AdminShoesRepository acr;
	
	@Autowired
	private AdminCategoryRepository adr;
	
	
	@RequestMapping("/shoes")
	public String listShoes(ModelMap model) {
		List<Shoe> shoes =  (List<Shoe>) acr.findAll();
		model.addAttribute("shoes",shoes);
		System.out.println(shoes);
		return "shoesHome";
	}
	

	@RequestMapping("/insertShoes")
	public String insertShoes(ModelMap model) {
		List<ShoeCategory> category =  (List<ShoeCategory>) adr.findAll();
		model.addAttribute("category",category);
		return "insertShoes";
	}
	
	@PostMapping
	@RequestMapping("/shoesInsert")
	public String shoesInsert(@RequestParam("name") String name,@RequestParam("price") String price,@RequestParam("category") String category,ModelMap model) {
		Shoe shoes = new Shoe();
		shoes.setName(name);
		shoes.setPrice(price);
		Optional<ShoeCategory> sCategory = adr.findByName(category);
		shoes.setCategory(sCategory.get());
		System.out.println(shoes);
		acr.save(shoes);
		model.addAttribute("message", "Inserted");
		return "shoesConfirm";
	}
	
	@GetMapping
	@RequestMapping("/shoesUpdate")
	public String shoesUpdate(@RequestParam("shoesid") String shoesid, HttpServletRequest request,ModelMap model) {
		HttpSession usersession = request.getSession();
		usersession.setAttribute("shoesid", shoesid);
		List<ShoeCategory> category =  (List<ShoeCategory>) adr.findAll();
		model.addAttribute("category",category);
		return "updateShoes";
	}
	
	@PostMapping
	@RequestMapping("/updateShoes")
	public String updateShoes(@RequestParam("name") String name,@RequestParam("price") String price,@RequestParam("category") String category, HttpServletRequest request, ModelMap model) {
		HttpSession usersession = request.getSession();
		Integer shoesid = Integer.parseInt((String) usersession.getAttribute("shoesid")) ;
		
		Optional<Shoe> shoe = acr.findById(shoesid);
		Shoe shoes = shoe.get();
		shoes.setName(name);
		shoes.setPrice(price);
		Optional<ShoeCategory> sCategory = adr.findByName(category);
		shoes.setCategory(sCategory.get());
		acr.save(shoes);
		model.addAttribute("message", "Updated");
		return "shoesConfirm";
	}
	
	
	@GetMapping
	@RequestMapping("/shoesDelete")
	public String shoesDelete(@RequestParam("shoesid") Integer shoesid,ModelMap model) {
		acr.deleteById(shoesid);
		model.addAttribute("message", "Deleted");
		return "shoesConfirm";
	}
}
