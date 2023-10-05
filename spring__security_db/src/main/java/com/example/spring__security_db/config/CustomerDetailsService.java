package com.example.spring__security_db.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.spring__security_db.entity.Employes;
import com.example.spring__security_db.repository.EmployesRepository;

public class CustomerDetailsService implements UserDetailsService{

	@Autowired
	EmployesRepository empRepo;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Employes emp = empRepo.findByEmail(email);
		if(emp == null)
		{
			System.out.println(emp+"  user not found...!!");
			throw new UsernameNotFoundException("email/username not found Exception");
		}
		else
		{
			return new CustomUser(emp);
		}
	}
	

}
