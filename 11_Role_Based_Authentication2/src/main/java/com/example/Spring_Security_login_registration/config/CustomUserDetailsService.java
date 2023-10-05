package com.example.Spring_Security_login_registration.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.example.Spring_Security_login_registration.entity.User;
import com.example.Spring_Security_login_registration.repository.UserRepository;

public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepository userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		System.out.println(email);
		System.out.println("======================================================");
		User user = userRepo.findByEmail(email);
		System.out.println(user);
		if(user == null)
		{
			throw new UsernameNotFoundException("email/user name not exists");
		}
		else
		{
			return new CustomUser(user);
		}
	}
}