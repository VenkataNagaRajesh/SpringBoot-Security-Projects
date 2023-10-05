package com.example.spring__security_db.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

	@Bean
	public BCryptPasswordEncoder passwordEncoder()
	{
		return new  BCryptPasswordEncoder();
		
	}
	
	
	@Bean
	public UserDetailsService getUserDetailsService()
	{
		return new CustomerDetailsService();
	}
	
	@Bean
	public DaoAuthenticationProvider daoAuthenticationProvider()
	{
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(getUserDetailsService());
		provider.setPasswordEncoder(passwordEncoder());
		return provider;
	}

	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception
	{
		http.csrf().disable()
					.authorizeHttpRequests()
					.requestMatchers("/index")
					.permitAll()
					.anyRequest()
					.authenticated()
					.and()
					.formLogin()
					.loginPage("/signin")
					.loginProcessingUrl("/login")
					.defaultSuccessUrl("/about").permitAll()
					.and()
					.logout()
					.logoutUrl("/logout")
		//	.failureUrl("/error")
			.permitAll();
			
		return http.build();
	}
}
