package com.example.Spring_Security_login_registration.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Spring_Security_login_registration.entity.User;
import com.example.Spring_Security_login_registration.repository.UserRepository;

@Controller
@RequestMapping("/user")
public class UserController {

	
	@Autowired
	UserRepository userRepo;
	
	
	@GetMapping("/profile")
	public String profile() {
		return "profile";
	}

	@ModelAttribute
	public void commonUser(Principal p,Model m) {
		if(p!=null)
		{
			String email = p.getName();
			User users = userRepo.findByEmail(email);
			m.addAttribute( "user",users);
		}
		
	}
}
