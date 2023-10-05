package com.example.BookStore.Management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BookStore.Management.entity.MyBookList;
import com.example.BookStore.Management.repository.MyBookRepo;

@Service
public class MyBookListServiceImplementation implements MyBookListService{

	@Autowired
	MyBookRepo myBookRepo;
	
	@Override
	public void saveMyBooks(MyBookList myBookList) {
		myBookRepo.save(myBookList);
		
	}

	@Override
	public List<MyBookList> getAllMyBooks() {
		return myBookRepo.findAll();
	}

	@Override
	public void deleteBooks(int id) {
		myBookRepo.deleteById(id);		
	}
}
