package com.BookStore.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BookStore.com.model.BookStore;
import com.BookStore.com.service.BookStoreService;

@RestController
@RequestMapping("/bookstore")
public class BookStoreController {

	@Autowired
	private BookStoreService service;

	@PostMapping("/post")
	public BookStore addBook(@RequestBody BookStore book) {
		return service.addBook(book);
	}

	@GetMapping("/getbookid/{bookid}")
	public BookStore getBookId(@PathVariable("bookid") int bookid) {
		return service.getbook(bookid);

	}

	@GetMapping("/getbookname/{bookname}")
	public List<BookStore> getBookName(@PathVariable("bookname") String bookname) {
		return service.getBookName(bookname);

	}
	@DeleteMapping("/delete/{bookid}")
	public String deleteBook(@PathVariable ("bookid") int bookid) {
		 service.deleteBook(bookid);
		 return "book deleted";
	}
	
	//@RequestMapping(value = "/update/{bookid}",method= {RequestMethod.PUT})
	//@PatchMapping("/update/{bookid}")
	@GetMapping("/update/{bookid}")
	public boolean updateBook(@PathVariable("bookid") int bookid) {
		return service.updateBook(bookid);
	}
}
