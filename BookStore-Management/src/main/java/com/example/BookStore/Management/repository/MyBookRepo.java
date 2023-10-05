package com.example.BookStore.Management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.BookStore.Management.entity.MyBookList;

@Repository
public interface MyBookRepo extends JpaRepository<MyBookList,Integer>{

}
