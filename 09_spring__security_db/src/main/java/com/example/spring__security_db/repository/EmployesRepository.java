package com.example.spring__security_db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.spring__security_db.entity.Employes;

@Repository
public interface EmployesRepository extends JpaRepository<Employes, Integer>{

	public Employes findByEmail(String email);
}
