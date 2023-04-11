package com.example.sportyShoes.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.sportyShoes.entity.Admin;
import com.example.sportyShoes.repository.AdminLoginRepository;

@Controller
@RequestMapping("/resetpassword")
public class ResetPassword {
	
	@Autowired
	private AdminLoginRepository alr;	
	
	@GetMapping
	public String passwordreset() {
		return "resetPassword";
	}
	
	@PostMapping
	public String resetPassword(@RequestParam("newpassword") String password) {
		Optional<Admin> adminentity = alr.findById(1);
		System.out.println(password);
		Admin admin = adminentity.get();
		admin.setPassword(password);
		alr.save(admin);
		return "home";
	}
	
}
