package com.example.BookStore.Management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.BookStore.Management.service.MyBookListService;

@Controller
public class MyBookListController {

	@Autowired
	private MyBookListService myBookListService;
	
	@RequestMapping("/delete_book/{id}")
	public String deleteMyList(@PathVariable("id") int id)
	{
		myBookListService.deleteBooks(id);
		 return "redirect:/my_books";
	}
}
