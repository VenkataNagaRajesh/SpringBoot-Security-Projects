package com.example.ManyToManyBiDirectional2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.ManyToManyBiDirectional2.Service.CustomerService;
import com.example.ManyToManyBiDirectional2.entity.Customer;
import com.example.ManyToManyBiDirectional2.entity.CustomerDto;
import com.example.ManyToManyBiDirectional2.repo.CustomerRepo;

@SpringBootApplication
public class ManyToManyBiDirectional2Application implements CommandLineRunner {

	@Autowired
	CustomerService service;
	
	public static void main(String[] args) {
	 ApplicationContext context =	SpringApplication.run(ManyToManyBiDirectional2Application.class, args);
	 CustomerService service = (CustomerService) context.getBean("customerService");
	 CustomerDto customerDto = new CustomerDto();
	 
//	 customerDto.setCustomerId(1);
//	 customerDto.setCustomerName("pavitra");
//	 customerDto.setEmail("pavitra@gmail.com");
//	 customerDto.setGender('F');
//	 customerDto.setPhoneNumber(9248494568L);
//	 customerDto.setAddress("hyd");
	 
//	 service.save(customerDto);
	 
//	 Customer customer = service.getCustomer(1);
//	 System.out.println(customer);
//	 
//	 Customer customer2 = service.updateCustomer(1, "delhi");
//	 System.out.println(customer2);
//	 
//	List<Customer> list = service.fetchAll();
//	
//	for(Customer l : list)
//	{
//		System.err.println(l.toString());
//	}

	 int k = (int)service.count()/2;
		System.out.println(k);
		for(int i=0;i<k;i++) {
			Pageable pageable = PageRequest.of(i, 3);
			 Iterable<Customer> customerList = service.findAll(pageable);
			 for(Customer cus:customerList)
			 {
				 
				 System.out.print(cus);
			 }
		}
		
		System.out.println();
		System.out.println("=============================================================================");
		System.out.println("sorted records are :");
		
		List<Customer> customersList =service.findAll(Sort.by(Sort.Direction.ASC,"address"));
		for(Customer cList: customersList)
		{
				System.out.println(cList);
		}
		System.out.println();

		System.out.println("=============================================================================");
		
	 
	 
	 System.out.println(service.getCounts());
	}

	@Override
	public void run(String... args) throws Exception {
		
		int k = (int)service.count()/2;
		System.out.println(k);
		for(int i=0;i<k;i++) {
			Pageable pageable = PageRequest.of(i, 3);
			 Iterable<Customer> customerList = service.findAll(pageable);
			 for(Customer cus:customerList)
			 {
				 
				 System.out.print(cus);
			 }
		}
		
		System.out.println();
		System.out.println("=============================================================================");
		System.out.println("sorted records are :");
		
		List<Customer> customersList =service.findAll(Sort.by(Sort.Direction.ASC,"address"));
		for(Customer cList: customersList)
		{
				System.out.println(cList);
		}
		System.out.println();

		System.out.println("=============================================================================");
		
		//System.out.println(service.getCounts());
		
		}
		
	
	

}
