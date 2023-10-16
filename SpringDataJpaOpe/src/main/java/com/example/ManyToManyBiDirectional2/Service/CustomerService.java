package com.example.ManyToManyBiDirectional2.Service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.example.ManyToManyBiDirectional2.entity.Customer;
import com.example.ManyToManyBiDirectional2.entity.CustomerDto;

public interface CustomerService {
	
	public Customer save(CustomerDto customerDto);
	
	public Customer getCustomer(Integer customerId);
	
	public Customer updateCustomer(Integer customerId,String address);

	public String deleteCustomer(Integer customerId);
	
	public List<Customer> fetchAll();
	
	
	Page<Customer> findAll(Pageable pageable);
	
	List<Customer> findAll(Sort sort);
	
	long count();
	
	
	public int getCounts();
}
