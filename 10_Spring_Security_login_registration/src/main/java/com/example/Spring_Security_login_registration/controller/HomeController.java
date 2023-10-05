package com.example.Spring_Security_login_registration.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.Spring_Security_login_registration.entity.User;
import com.example.Spring_Security_login_registration.repository.UserRepository;
import com.example.Spring_Security_login_registration.service.UserServiceImp;
import com.example.Spring_Security_login_registration.service.userService;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {

	@Autowired
	private userService userService;
	
	@Autowired
	private UserRepository userRepo;
	@Autowired
	UserServiceImp userServiceImple;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}

	@GetMapping("/home")
	public String home() {
		return "home";
	}

	@GetMapping("/user/about")
	public String about() {
		return "about";
	}

	@GetMapping("/signin")
	public String login() {
		return "login";
	}

	@GetMapping("/user/profile")
	public String profile(Principal p,Model m) {
		String email = p.getName();
		User users = userRepo.findByEmail(email);
		m.addAttribute( "users",users);
		return "profile";
	}

	@GetMapping("/registration")
	public String registration() {
		return "registration";
	}

	@PostMapping("/saveUser")
	public String saveUser(@ModelAttribute User user, HttpSession session) {
		System.out.println(user.toString());
		User savedUser = userService.saveUser(user);
		//String msg1 = userServiceImple.removeSessionMessage();
		if (savedUser == null) {
			System.out.println("user not saved");
			session.setAttribute("msg", "User not registered ");
		} else {
			session.setAttribute("msg", "user saved successfully..");
			System.out.println("user saved successfully..");
		}
		return "redirect:/registration";
	}
	@GetMapping("/logout")
	public String logout() {
		return "redirect:/signin";
	}
}
