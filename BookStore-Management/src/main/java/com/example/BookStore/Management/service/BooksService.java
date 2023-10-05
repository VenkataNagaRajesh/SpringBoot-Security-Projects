package com.example.BookStore.Management.service;

import java.util.List;

import com.example.BookStore.Management.entity.Books;

public interface BooksService {

	public void saveBook(Books b);
	
	public List<Books> getAllBooks();
	
	public Books getMyBookById(int id);
	
	public void deleteBooks(int id);
}
