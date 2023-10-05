package com.example.RegistrationDemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.RegistrationDemo.entity.User;
import com.example.RegistrationDemo.repo.UserRepository;

@Service
public class UserServiceImplementation  implements UserService{

	@Autowired
	public UserRepository userRepository;
	
	@Override
	public void registerUser(User user) {
		userRepository.save(user);
		System.out.println("saving process done");
	}

}
