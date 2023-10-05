package com.example.Spring_Security_login_registration.service;

import com.example.Spring_Security_login_registration.entity.User;


public interface userService {
	
	public User saveUser(User user);
	
	public void removeSessionMessage();
	
	 public User findUserByEmail(String email);
}

