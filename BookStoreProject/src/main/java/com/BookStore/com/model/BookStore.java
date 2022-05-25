package com.BookStore.com.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BookStore {
	@Id
	private int bookid;
	private String bookname;
	private double bookprice;
	private String booksoldstatus;
	public BookStore() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BookStore(int bookid, String bookname, double bookprice, String booksoldstatus) {
		super();
		this.bookid = bookid;
		this.bookname = bookname;
		this.bookprice = bookprice;
		this.booksoldstatus = booksoldstatus;
	}
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public double getBookprice() {
		return bookprice;
	}
	public void setBookprice(double bookprice) {
		this.bookprice = bookprice;
	}
	public String getBooksoldstatus() {
		return booksoldstatus;
	}
	public void setBooksoldstatus(String booksoldstatus) {
		this.booksoldstatus = booksoldstatus;
	}

	
}
