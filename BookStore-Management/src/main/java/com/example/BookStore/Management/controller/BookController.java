package com.example.BookStore.Management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.BookStore.Management.entity.Books;
import com.example.BookStore.Management.entity.MyBookList;
import com.example.BookStore.Management.service.BooksService;
import com.example.BookStore.Management.service.MyBookListService;

@Controller
public class BookController {
	
	@Autowired
	BooksService bookService;
	
	@Autowired
	MyBookListService myBookListService;
	
	@GetMapping("/")
	public String home()
	{
		return "home";
	}
	
	@GetMapping("/book_register")
	public String bookRegister()
	{
		return "bookRegister";
	}
	
	
	@GetMapping("/availble_books")
	public ModelAndView getAllBooks()
	{
		List<Books> list = bookService.getAllBooks();
		return new ModelAndView("books_list","book",list);
	}
	
	@PostMapping("/saveBook")
	public String saveBook(@ModelAttribute Books b)
	{
		bookService.saveBook(b);
		return "redirect:/availble_books";
	}
	
	
	@GetMapping("my_books")
	public ModelAndView myBooks()
	{
		List<MyBookList> myBookLists = myBookListService.getAllMyBooks();
		return new ModelAndView("myBooks","my_books",myBookLists);
	}
	
	@RequestMapping("/mylist/{id}")
	public String getMyBookList(@PathVariable("id") int id)
	{
		System.out.println(id+" here ");
		Books b = bookService.getMyBookById(id);
		MyBookList m = new MyBookList(b.getId(),b.getAuthor(),b.getName(),b.getPrice());
		myBookListService.saveMyBooks(m);
		return "redirect:/my_books";
	}
	
	@RequestMapping("delete_availble_book/{id}")
	public String delte_Book(@PathVariable("id") int id)
	{
		bookService.deleteBooks(id);
		return "redirect:/availble_books";
	}
	
	@RequestMapping("edit_book/{id}")
	public String edit_book(@PathVariable("id") int id,Model model)
	{
		List<Books> b = bookService.getAllBooks();
		model.addAttribute("book", b);
		return "edit_book";
		
	}
}
