package com.BookStore.com.repository;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;
@Repository
public class BookRepositoryImpl implements BookStoreRepository {

	@Override
	public SessionFactory factoryMethod() {
		Configuration con = new Configuration();
		con.configure("hibernate.cfg2.xml");
		SessionFactory factory = con.buildSessionFactory();

		return factory;
	}

}
