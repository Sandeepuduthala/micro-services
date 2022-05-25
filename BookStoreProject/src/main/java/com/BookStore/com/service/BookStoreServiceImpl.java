package com.BookStore.com.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BookStore.com.model.BookStore;
import com.BookStore.com.repository.BookStoreRepository;

@Service
public class BookStoreServiceImpl implements BookStoreService {

	@Autowired
	private BookStoreRepository repo;

	@Override
	public BookStore addBook(BookStore book) {

		Session sess = repo.factoryMethod().openSession();
		Transaction tr = sess.beginTransaction();
		sess.save(book);
		tr.commit();

		return book;
	}

	@Override
	public BookStore getbook(int bookid) {

		Session sess = repo.factoryMethod().openSession();
		Transaction tr = sess.beginTransaction();
		BookStore bookStore = sess.get(BookStore.class, bookid);

		return bookStore;

	}

	@Override
	public List<BookStore> getBookName(String bookname) {
		Session sess = repo.factoryMethod().openSession();
		Transaction tr = sess.beginTransaction();
		Query query = sess
				.createQuery("select bookid ,bookname,bookprice,booksoldstatus from BookStore where bookname=:m");
		query.setParameter("m", bookname);
		List<BookStore> l = query.list();
		return l;
	}

	@Override
	public String deleteBook(int bookid) {
		Session sess = repo.factoryMethod().openSession();
		Transaction tr = sess.beginTransaction();

		return "book deleted";
	}

	@Override
	public boolean updateBook(int bookid) {
		Session session = repo.factoryMethod().openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("update BookStore b set b.booksoldstatus='yes' where b.bookid=:m");
		query.setParameter("m", bookid);
		query.executeUpdate();
		transaction.commit();
		return true;
	}

}
