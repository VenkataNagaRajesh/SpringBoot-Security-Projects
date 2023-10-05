package com.example.spring_securitybasic2;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Demo {

	public static void main(String[] s)
	{
		System.out.println(new BCryptPasswordEncoder().encode("1235"));
	}
}
