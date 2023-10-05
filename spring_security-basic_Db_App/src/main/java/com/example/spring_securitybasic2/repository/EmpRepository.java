package com.example.spring_securitybasic2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.spring_securitybasic2.entity.Employee;

@Repository
public interface EmpRepository extends JpaRepository<Employee, Integer>
{

	public Employee findByEmail(String email);
}
