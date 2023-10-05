package com.example.Spring_Security_login_registration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.example.Spring_Security_login_registration.entity.User;
import com.example.Spring_Security_login_registration.repository.UserRepository;

import jakarta.servlet.http.HttpSession;

@Service
public class UserServiceImp implements userService {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public User saveUser(User user) {

		String upassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(upassword);
		user.setRole("ROLE_USER");
		User users = userRepo.save(user);
		return users;
	}

	@Override
	public void removeSessionMessage() {
		HttpSession session = ((ServletRequestAttributes) (RequestContextHolder.getRequestAttributes())).getRequest()
				.getSession();
		session.removeAttribute("msg");
	}
	
	
	
	 @Override
	    public User findUserByEmail(String email) {
	        return userRepo.findByEmail(email);
	    }

}
