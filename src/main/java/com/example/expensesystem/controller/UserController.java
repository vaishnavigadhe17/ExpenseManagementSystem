package com.example.expensesystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.expensesystem.entity.User;
import com.example.expensesystem.repository.UserRepository;
@Controller

public class UserController {
	
	@Autowired
	private UserRepository repo;
	
	@GetMapping("/")
	public String homePage(Model model) {
		model.addAttribute("user",new User());
		return "signup";
	}
	
	@GetMapping("/calculator")
    public String calculator() {
        return "calculator";
    }
	
	@PostMapping("/save")
	public String saveUser(User user) {
		repo.save(user);
		return "signin";
	}
		
	@GetMapping("/login")
	public String login(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "signin";		
	}
	
	@GetMapping("/index")
	public String index() {
		return "index";
	}
	
	
	@PostMapping("/login")
	public String loginUser(@ModelAttribute("users") User user) {
		String username = user.getUsername();
		User userdata = this.repo.findByUsername(username);
		if(user.getPassword().equals(userdata.getPassword())) {
			return "index";	
		}
		else {
			return "error";
		} 
	}
}
