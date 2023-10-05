package com.example.spring_securitybasic.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String index()
	{
		return "index";
	}
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@RequestMapping("/home")
	public String home()
	{
		return "home";
	}
	@PreAuthorize("hasAuthority('ROLE_USER')")
	@RequestMapping("/about")
	public String about()
	{
		return "about";
	}
}
