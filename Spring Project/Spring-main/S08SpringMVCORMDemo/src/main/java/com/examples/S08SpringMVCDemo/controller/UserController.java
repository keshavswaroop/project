package com.examples.S08SpringMVCDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.examples.S08SpringMVCDemo.entity.User;
import com.examples.S08SpringMVCDemo.exception.UserAlreadyExistsException;
import com.examples.S08SpringMVCDemo.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	@RequestMapping("/register")
	public String showRegistrationPage() {
		return "userreg";
	}
	
	@RequestMapping("/registeruser")
	public String registerUser(@ModelAttribute("user") User user,ModelMap model) throws UserAlreadyExistsException {
		int result;
		try{
			result = userService.save(user);
			model.addAttribute("users" ,userService.getUsers());
			System.out.println(user);
		
		
		}catch(UserAlreadyExistsException uaex) {
			model.addAttribute("message",uaex.getMessage());
		}
		return "userreg";
		
	}
	
	@RequestMapping("/users")
	public String getUsers(ModelMap model) {
		
		model.addAttribute("users" ,userService.getUsers());
		return "dispalyusers";
	}
}
