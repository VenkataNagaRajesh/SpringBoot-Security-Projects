package com.example.spring_securitybasic2.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.example.spring_securitybasic2.entity.Employee;
import com.example.spring_securitybasic2.repository.EmpRepository;

@Component
public class CustomUserDetialService implements UserDetailsService{

	@Autowired
	private EmpRepository empRepo;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Employee emp = empRepo.findByEmail(email);
		if(emp == null)
		{
			throw new UsernameNotFoundException("user/email not found");
		}
		else
		{
			return new CustomUser(emp);
		}
	}

}
