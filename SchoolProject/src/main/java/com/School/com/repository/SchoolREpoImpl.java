package com.School.com.repository;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;
@Repository
public class SchoolREpoImpl implements SchoolRepository {
	@Override
	public SessionFactory factoryMethod() {

		Configuration con = new Configuration();
		con.configure("hibernate.cfg.xml");

		SessionFactory fact = con.buildSessionFactory();

		return fact;
	}

}
