package com.School.com.service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.School.com.model.SchoolData;
import com.School.com.repository.SchoolRepository;
import com.School.com.vo.BookStore;
import com.School.com.vo.ResponseTerms;
import org.springframework.web.client.RestTemplate;
@Service
public class SchoolServiceImpl implements SchoolService {
	@Autowired
	private SchoolRepository repo;

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public SchoolData savedata(SchoolData school) {

		Session sess = repo.factoryMethod().openSession();
		Transaction tr = sess.beginTransaction();
		BookStore bookStore = null;

		bookStore = restTemplate.getForObject("http://localhost:8001/bookstore/getbookid/" + school.getBookid(),
				BookStore.class);

		System.out.println(bookStore.getBookname() + " " + bookStore.getBooksoldstatus());

		if (bookStore.getBooksoldstatus().equalsIgnoreCase("no")) {
			sess.save(school);
			System.out.println("successfullu saved!!");

			// bookStore =
			// restTemplate.getForObject("http://localhost:8001/bookstore/update/" +
			// school.getBookid(),BookStore.class);

			// restTemplate.patchForObject("http://localhost:8001/bookstore/update/",
			// school.getBookid(), BookStore.class);

			// bookStore=restTemplate.getForObject("http://localhost:8001/bookstore/update/"
			// + school.getBookid(),
			// bookStore.getClass());

			try {
				System.out.println("step1");

				HttpRequest request1 = HttpRequest.newBuilder()
						.uri(new URI("http://localhost:8001/bookstore/update/" + school.getBookid())).build();
				System.out.println(request1.uri());

				HttpResponse response1 = HttpClient.newHttpClient().send(request1,
						HttpResponse.BodyHandlers.discarding());
				System.out.println("step2");

			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}

			/*
			 * // restTemplate.exchange( "httpR://localhost:8001/bookstore/update/" + //
			 * school.getBookid(),HttpMethod.PUT, bookStore,String.class); int
			 * id=school.getBookid(); BookStore b=
			 * restTemplate.exchange("http://localhost:8001/bookstore/update/" +
			 * school.getBookid(), HttpMethod.PUT, bookStore, Boolean.class,id );
			 */
			
			tr.commit();

		} else {
			System.out.println("ghjygfjgfuguiguigi");
		}
		return school;
	}

	@Override
	public ResponseTerms getDetails(int schoolid) {
		Session session = repo.factoryMethod().openSession();
		Transaction transaction = session.beginTransaction();

		ResponseTerms responseTerms = new ResponseTerms();

		return null;
	}

	@Override
	public boolean deleteEntity() {
		Session session = repo.factoryMethod().openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("delete from SchoolData");
		query.executeUpdate();
		transaction.commit();

		return true;
	}

}
