package com.example.login_registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.login_registration.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	
	User findByusername(String username);	
}
