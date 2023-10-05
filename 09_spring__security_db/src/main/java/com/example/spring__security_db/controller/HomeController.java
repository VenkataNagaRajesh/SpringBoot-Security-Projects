package com.example.spring__security_db.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	@GetMapping("/index")
	public String index() {
		return "index";
	}

	@GetMapping("/home")
	public String home() {
		return "home";
	}

	@GetMapping("/signin")
	public String signin() {
		return "login";
	}

	@GetMapping("/about")
	public String about() {
		return "about";
	}

	@GetMapping("/profile")
	public String profile() {
		return "profile";
	}
	
	@GetMapping("/error")
	public String error()
	{
		return "error";
	}
	
	@GetMapping("/logout")
	public String logout()
	{
		return "logout";
	}
	
}
