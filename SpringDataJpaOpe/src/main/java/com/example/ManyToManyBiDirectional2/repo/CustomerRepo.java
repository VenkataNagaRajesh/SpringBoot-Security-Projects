package com.example.ManyToManyBiDirectional2.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

import com.example.ManyToManyBiDirectional2.entity.Customer;


public interface CustomerRepo extends JpaRepository<Customer, Integer>
{

	//Customer save(Customer prepareCustomer);
	
	@Procedure(procedureName = "sample_procedure")
	public int getCount();
}
