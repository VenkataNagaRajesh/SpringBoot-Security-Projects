package com.example.Spring_Security_login_registration.service;

import com.example.Spring_Security_login_registration.entity.User;


public interface userService {
	
	public User saveUser(User user,String path);
	
	public void removeSessionMessage();
	
	 public User findUserByEmail(String email);
	 
	 public void sendEmail(User user,String path);
	 
	 public boolean verifyAccount(String verificationCode);
}

