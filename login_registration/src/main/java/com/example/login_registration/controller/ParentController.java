package com.example.login_registration.controller;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.login_registration.entity.User;
import com.example.login_registration.service.UserService;

import ch.qos.logback.core.net.SyslogOutputStream;

@Controller
public class ParentController {
	
	@Autowired
	UserService userService;
	private Object Boolean;
	@GetMapping("/")
	public String show()
	{
		return "home";
	}
	@GetMapping("/registration")
	public String registrationPage(User user)
	{
		return "RegistrationPage";
	}
	
	@GetMapping("/login")
	public String loginPage(User user)
	{
		return "login";
	}
	
	@PostMapping("/loginProcess")
	@ResponseBody
	public String loginProcess(@RequestParam("username")String username,@RequestParam("password")String  password)
	{
		System.out.println(username+" "+password);
		User userName = userService.findByUsername(username);
		System.out.println(userName.getPassword());
		if(userName == null) {
			return "login";
		}
		else
			{
			Boolean isPasswordMatch = BCrypt.checkpw(password, userName.getPassword());
			System.out.println(isPasswordMatch);
			if(isPasswordMatch)
				return "welcome to loginPage";
			else
				return "loginlnln";
			}
		
	}
	@PostMapping("/register")
	@ResponseBody
	public String register(@ModelAttribute("user") User user) 
	{
	System.out.println(user.toString());
	String hashedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(6));
	user.setPassword(hashedPassword);
	userService.saveUser(user);
		return "welcome";
	}
	
	
}
