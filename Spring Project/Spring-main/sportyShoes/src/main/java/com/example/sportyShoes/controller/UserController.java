package com.example.sportyShoes.controller;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.sportyShoes.entity.Purchase;
import com.example.sportyShoes.entity.Shoe;
import com.example.sportyShoes.entity.ShoeCategory;
import com.example.sportyShoes.entity.User;
import com.example.sportyShoes.repository.AdminCategoryRepository;
import com.example.sportyShoes.repository.AdminShoesRepository;
import com.example.sportyShoes.repository.PurchaseDetailsRepository;
import com.example.sportyShoes.repository.UserRepository;

@Controller
public class UserController {
	
	@Autowired
	private UserRepository userrepo;
	
	@Autowired
	private AdminCategoryRepository categoryrepo;
	
	@Autowired
	private AdminShoesRepository shoesrepo;
	
	@Autowired
	private PurchaseDetailsRepository purrepo;
	
	
	@RequestMapping("/addShoes")
	public ModelAndView register(@Param("shoesid") Integer shoesid,HttpServletRequest request) {
		HttpSession session= request.getSession();
		Object user = session.getAttribute("user");
		List<Purchase> pur1 = (List<Purchase>) session.getAttribute("reportDetails");
		User user3 = (User) user;
		Integer userid = user3.getId();
		
		Optional<User> user1 = userrepo.findById(userid);
		User user2 = user1.get();
		
		Optional<Shoe> shoe = shoesrepo.findById(shoesid);
		Shoe shoe1 = shoe.get();
		
		Optional<ShoeCategory> category = categoryrepo.findById(shoe1.getCategory().getId());
		ShoeCategory category1 = category.get();
		
		Purchase purchase = new Purchase();
		purchase.setUser(user2);
		purchase.setCategory(category1);
		purchase.setDate(LocalDate.now());
		purchase.setShoe(shoe1);
		
		
		pur1.add(purchase);
		
		
		URI uri= UriComponentsBuilder.fromPath("/userHome").build().toUri();
		
		RedirectView redirectView = new RedirectView(uri.toString(),true);
		
		
		return new ModelAndView(redirectView);
	}
	
	@PostMapping
	@RequestMapping("/filters")
	public String filters(@Param("category") String category,ModelMap model) {
		List<Shoe> shoe;
		System.out.println(category + "---------------------------------------------------");
		
		if(category.equals("all")) {
			shoe = (List<Shoe>) shoesrepo.findAll();
			
		}
		
		else {
			Optional<ShoeCategory> cat=categoryrepo.findByName(category);
			
			shoe = shoesrepo.findByCategory(cat.get());
		}
		System.out.println("----------------------------------"+shoe);
		model.addAttribute("shoes", shoe);
		List<ShoeCategory> category3 = (List<ShoeCategory>) categoryrepo.findAll();
		model.addAttribute("category", category3);
		return "userHome";
	}
	
	@RequestMapping("/booknow")
	public String booknow() {
		return "booking";
	}
	
	
	@RequestMapping("/payments")
	public String payments() {
		return "payment";
	}
	
	@RequestMapping("/bookingConfirm")
	public String bookingConfirm(HttpServletRequest request,ModelMap model) {
		HttpSession session= request.getSession();
		List<Purchase> pur1 = (List<Purchase>) session.getAttribute("reportDetails");
		
		int n=0;
		Integer total=0;
		for(Purchase purchase: pur1) {
			purrepo.save(purchase);
			n=n+1;
			total=total+Integer.parseInt(purchase.getShoe().getPrice());
		}
		model.addAttribute("total",total);
		model.addAttribute("n",n);
		
		
		pur1.clear();
		
		
		return "bookingConfirm";
	}
}
