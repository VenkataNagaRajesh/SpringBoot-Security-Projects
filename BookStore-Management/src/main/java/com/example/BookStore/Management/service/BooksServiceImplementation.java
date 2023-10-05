package com.example.BookStore.Management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BookStore.Management.entity.Books;
import com.example.BookStore.Management.repository.BookRepo;

@Service
public class BooksServiceImplementation  implements BooksService{

	@Autowired
	BookRepo bookRepo;
	
	@Override
	public void saveBook(Books b) {
		bookRepo.save(b);
	}

	@Override
	public List<Books> getAllBooks() {
		
		return bookRepo.findAll();
	}

	

	@Override
	public Books getMyBookById(int id) {
		return bookRepo.findById(id).get();
	}

	@Override
	public void deleteBooks(int id) {
		bookRepo.deleteById(id);	
	}

	
}
