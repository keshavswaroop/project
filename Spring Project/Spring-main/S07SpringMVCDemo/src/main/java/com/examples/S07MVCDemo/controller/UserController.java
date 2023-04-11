package com.examples.S07MVCDemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.examples.S07MVCDemo.model.User;

@Controller
public class UserController {
	@RequestMapping("/register")
	public String showRegistrationPage() {
		return "registeruser"; //view name is directly returned
	}
	
	@RequestMapping(value="/signupuser",method=RequestMethod.POST)
	public String signup(@ModelAttribute("user") User user,ModelMap model) {
		
		model.addAttribute("user",user);
		
		return "result";
	}
}
