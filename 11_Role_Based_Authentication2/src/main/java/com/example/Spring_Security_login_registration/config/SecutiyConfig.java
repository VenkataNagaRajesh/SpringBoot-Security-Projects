package com.example.Spring_Security_login_registration.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.example.Spring_Security_login_registration.repository.UserRepository;

@Configuration
@EnableWebSecurity
public class SecutiyConfig {

	@Autowired
	public CustomAuthSuccessHandler successHandler;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public UserDetailsService getUserDetailsService()
	{
		return new CustomUserDetailsService();
	}
	
	@Bean
	public DaoAuthenticationProvider getAuthenticationProvider()
	{
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setUserDetailsService(getUserDetailsService());
		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
		return daoAuthenticationProvider;
		
	}
	
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception
	{
//		http.csrf().disable()
//		.authorizeHttpRequests()
//		.requestMatchers("/","/registration","/saveUser","/signin","/home")
//		.permitAll()
//		.requestMatchers("/user/**")
//		.authenticated()
//		.and()
//		.formLogin()
//		.loginPage("/signin")
//		.loginProcessingUrl("/login")
//		//.usernameParameter("email")
//		.defaultSuccessUrl("/user/profile")
//		.permitAll();
		
		http.csrf().disable()
				   .authorizeHttpRequests()
				   .requestMatchers("/user/**")
				   .hasRole("USER")
				   .requestMatchers("/admin/**")
				   .hasRole("ADMIN")
				   .requestMatchers("/**")
				   .permitAll()
				   .and()
				   .formLogin()
				   .loginPage("/signin")
				   .loginProcessingUrl("/login")
				   .successHandler(successHandler)
				   .and()
				   .logout().permitAll();
		return http.build();
	}
	
	

}
