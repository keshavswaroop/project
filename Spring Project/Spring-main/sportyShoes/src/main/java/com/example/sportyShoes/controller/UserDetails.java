package com.example.sportyShoes.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.sportyShoes.entity.Purchase;
import com.example.sportyShoes.entity.Shoe;
import com.example.sportyShoes.entity.ShoeCategory;
import com.example.sportyShoes.entity.User;
import com.example.sportyShoes.repository.AdminCategoryRepository;
import com.example.sportyShoes.repository.AdminShoesRepository;
import com.example.sportyShoes.repository.UserRepository;

@Controller
public class UserDetails {

	@Autowired
	private UserRepository userrepo;

	@Autowired
	private AdminShoesRepository shoerepo;

	@Autowired
	private AdminCategoryRepository categoryrepo;

	@RequestMapping("/register")
	public String register() {
		return "userLogin";
	}

	@PostMapping
	@RequestMapping("/login")
	public String login(@RequestParam("name") String name, @RequestParam("email") String email,
			@RequestParam("phone") String phone, @RequestParam("address") String address,
			@RequestParam("password") String password, ModelMap model) {
		User user = new User();
		user.setName(name);
		user.setEmail(email);
		user.setAddress(address);
		user.setPhone(phone);
		user.setPassword(password);
		userrepo.save(user);
		return "userSignup";
	}

	@RequestMapping("/signupregister")
	public String signupregister() {
		return "userSignup";
	}

	@PostMapping
	@RequestMapping("/homeUser")
	public String signup(@RequestParam("email") String email, @RequestParam("password") String password,
			HttpServletRequest request,ModelMap model) {
		Optional<User> user = userrepo.findByEmail(email);
		User user1 = user.get();
		System.out.println(user1);
		if (user1.getPassword().equals(password)) {
			HttpSession usersession = request.getSession();
			usersession.setAttribute("user", user1);
			List <Purchase> reportDetails = new ArrayList<>();
			usersession.setAttribute("reportDetails", reportDetails);
			List<Shoe> shoe = (List<Shoe>) shoerepo.findAll();
			List<ShoeCategory> category = (List<ShoeCategory>) categoryrepo.findAll();
			model.addAttribute("category", category);
			model.addAttribute("shoes", shoe);
			return "userHome";
		}

		else {
			return "userSignup";
		}

	}

	@RequestMapping("/userHome")
	public String userHome(ModelMap model) {
		List<Shoe> shoe = (List<Shoe>) shoerepo.findAll();
		List<ShoeCategory> category = (List<ShoeCategory>) categoryrepo.findAll();
		model.addAttribute("category", category);
		model.addAttribute("shoes", shoe);
		return "userHome";
	}
	
	@RequestMapping("/userDetails")
	public String userDetails(ModelMap model) {
		System.out.println("hi");
		List<User> user = (List<User>) userrepo.findAll();
		System.out.println(user);
		model.addAttribute("users",user);
		return "userDetails";
	}
	
	@PostMapping
	@RequestMapping("/userSearch")
	public String userSearch(@RequestParam("search") String name,ModelMap model) {
		if(name.isEmpty() || name.isBlank()) {
			List<User> user = (List<User>) userrepo.findAll();
			model.addAttribute("users",user);
		}
		else {
			List<User> user = userrepo.findAllByName(name);
			model.addAttribute("users",user);
		}
		
		
		return "userDetails";
	}
}
