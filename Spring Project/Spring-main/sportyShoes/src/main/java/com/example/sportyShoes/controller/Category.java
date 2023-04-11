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

import com.example.sportyShoes.entity.Admin;
import com.example.sportyShoes.entity.ShoeCategory;
import com.example.sportyShoes.repository.AdminCategoryRepository;

@Controller
public class Category {
	
	@Autowired
	private AdminCategoryRepository acr;
	
	
	@RequestMapping("/category")
	public String listCategory(ModelMap model) {
		List<ShoeCategory> category =  (List<ShoeCategory>) acr.findAll();
		model.addAttribute("category",category);
		System.out.println(category);
		return "categoryHome";
	}
	

	@RequestMapping("/insertCategory")
	public String insertCategory() {
		return "insertCategory";
	}
	
	@PostMapping
	@RequestMapping("/categoryInsert")
	public String categoryInsert(@RequestParam("name") String name,ModelMap model) {
		ShoeCategory category = new ShoeCategory();
		category.setName(name);
		acr.save(category);
		model.addAttribute("message", "New Category Added Successfully");
		return "categoryConfirm";
	}
	
	@GetMapping
	@RequestMapping("/categoryUpdate")
	public String categoryUpdate(@RequestParam("categoryid") String categoryid, HttpServletRequest request) {
		HttpSession usersession = request.getSession();
		usersession.setAttribute("categoryid", categoryid);
		return "updateCategory";
	}
	
	@PostMapping
	@RequestMapping("/updateCategory")
	public String updateCategory(@RequestParam("name") String categoryname,ModelMap model, HttpServletRequest request) {
		HttpSession usersession = request.getSession();
		Integer categoryid = Integer.parseInt((String) usersession.getAttribute("categoryid")) ;
		Optional<ShoeCategory> category = acr.findById(categoryid);
		ShoeCategory shoe = category.get();
		shoe.setName(categoryname);
		acr.save(shoe);
		model.addAttribute("message", "deleted");
		return "categoryConfirm";
	}
	
	
	@GetMapping
	@RequestMapping("/categoryDelete")
	public String categoryDelete(@RequestParam("categoryid") Integer categoryid,ModelMap model) {
		acr.deleteById(categoryid);
		model.addAttribute("message", "deleted");
		return "categoryConfirm";
	}
}
