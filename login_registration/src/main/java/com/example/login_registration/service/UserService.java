package com.example.login_registration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.login_registration.entity.User;
import com.example.login_registration.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepo;
	
	public void saveUser(User user)
	{
		userRepo.save(user);
	}
	
	public User findByUsername(String username)
	{
		User user =  userRepo.findByusername(username);
		System.out.print(user);
		return user;
	}
}
