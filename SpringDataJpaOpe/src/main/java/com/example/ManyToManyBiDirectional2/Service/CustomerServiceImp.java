package com.example.ManyToManyBiDirectional2.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.ManyToManyBiDirectional2.entity.Customer;
import com.example.ManyToManyBiDirectional2.entity.CustomerDto;
import com.example.ManyToManyBiDirectional2.repo.CustomerRepo;

@Service("customerService")
public class CustomerServiceImp implements CustomerService {

	@Autowired
	CustomerRepo customerRepo;
	
	@Override
	public Customer save(CustomerDto customerDto) {
		System.out.println(customerDto.toString());
		
		System.out.println(CustomerDto.prepareCustomer(customerDto).toString());
		return customerRepo.save(CustomerDto.prepareCustomer(customerDto));
	}

	@Override
	public Customer getCustomer(Integer customerId) {
		
		return customerRepo.findById(customerId).get();
	}

	@Override
	public Customer updateCustomer(Integer customerId, String address) {
		Customer customer = customerRepo.findById(customerId).get();
		customer.setAddress(address);
	 Customer updatedCustomer =	customerRepo.save(customer);
		return updatedCustomer;
	}

	@Override
	public String deleteCustomer(Integer customerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> fetchAll() {
		return customerRepo.findAll();
	}

	@Override
	public Page<Customer> findAll(Pageable pageable) {
		return customerRepo.findAll(pageable);
	}

	@Override
	public List<Customer> findAll(Sort sort) {
		return customerRepo.findAll(sort);
	}


	public long count() {
		// TODO Auto-generated method stub
		return customerRepo.count();
	}

	@Override
	public int getCounts() {
		return customerRepo.getCount();
	}

}
