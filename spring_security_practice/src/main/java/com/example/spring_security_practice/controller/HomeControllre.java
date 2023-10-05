package com.example.spring_security_practice.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeControllre {
	@GetMapping("/index")
	public String index()
	{
		return "index";
	}

	@GetMapping("/home")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public String home()
	{
		return "home";
	}	
	
	@GetMapping("/about")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	public String about()
	{
		return "about";
	}
}
