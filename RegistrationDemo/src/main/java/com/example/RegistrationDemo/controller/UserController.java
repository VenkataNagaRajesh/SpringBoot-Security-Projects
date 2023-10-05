package com.example.RegistrationDemo.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.RegistrationDemo.entity.Books;
import com.example.RegistrationDemo.entity.User;
import com.example.RegistrationDemo.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userService;
	
	@RequestMapping("/reg")
	public String userRegistration(Model model)
	{
		User user = new User();
		List<Books> selectedBooks = Arrays.asList(
				new Books(1,"java"),
				new Books(1,"C language"),
				new Books(3,"C++"),
				new Books(4,"Angular Js"),
				new Books(5,"php")
				);
		model.addAttribute("user",user);
		model.addAttribute("selectedBooks",selectedBooks);
		return "register";
	}
	
	@PostMapping("/registerUser")
	public String registerUser(@ModelAttribute("user")User user) {
		System.out.print(user);
		userService.registerUser(user);
		return "home";
	}
}
