package com.BookStore.com.service;

import java.util.List;

import com.BookStore.com.model.BookStore;

public interface BookStoreService {

	public BookStore addBook(BookStore book);

	public BookStore getbook(int bookid);

	public List<BookStore> getBookName(String bookname);

	public String deleteBook(int bookid);

	public boolean updateBook(int bookid);

}
