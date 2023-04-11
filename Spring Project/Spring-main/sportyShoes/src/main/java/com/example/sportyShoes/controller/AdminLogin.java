package com.example.sportyShoes.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.sportyShoes.entity.Admin;
import com.example.sportyShoes.repository.AdminLoginRepository;


@Controller
public class AdminLogin {
	@Autowired
	private AdminLoginRepository adminrepo;
	
	@Autowired
	private HttpServletRequest request;
	
	@RequestMapping("/admin")
	public String adminCredentials(ModelMap model) {
		
		String name = "Sporty Shoes";
		String email = "simplilearn@gmail.com";
		String password = "admin";
		Admin admin = new Admin();
		admin.setName(name);
		admin.setEmail(email);
		admin.setPassword(password);
		adminrepo.save(admin);
		return "adminLogin";
	}
	
	
	@PostMapping
	@RequestMapping("/adminCheck")
	public String addProduct(@RequestParam("email") String emailform,@RequestParam("password") String passwordform,ModelMap model) {
		
		List<Admin> login = (List<Admin>) adminrepo.findAll();
		System.out.println(login);

		if ((login.get(0).getEmail()).equals(emailform) && (login.get(0).getPassword()).equals(passwordform)) {
			HttpSession usersession = request.getSession();
			usersession.setAttribute("LoginCredentials", login.get(0));
			return "home";
		} else {
			return "adminLogin";
		}
	}
	
	
	@RequestMapping("/adminHome")
	public String home() {
		return "home";
	}
	
}
