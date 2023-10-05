package com.example.sms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.sms.entity.Student;
import com.example.sms.repository.StudentRepository;

@SpringBootApplication
public class SmsApplication implements CommandLineRunner{

	@Autowired
	StudentRepository studentRepo;
	public static void main(String[] args) {
		SpringApplication.run(SmsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Student student1 = new Student("Ramesh","Fadatare","ramesh@gmail.com");
		studentRepo.save(student1);
		Student student2 = new Student("Rakesh","Fadstern","rakesh@gmail.com");
		studentRepo.save(student2);
		
		
	}
	
	

}
