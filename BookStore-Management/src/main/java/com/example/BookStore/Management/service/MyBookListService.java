package com.example.BookStore.Management.service;

import java.util.List;

import com.example.BookStore.Management.entity.MyBookList;

public interface MyBookListService {

	public void saveMyBooks(MyBookList myBookList);
	
	public List<MyBookList> getAllMyBooks();
	
	public void deleteBooks(int id);
}
