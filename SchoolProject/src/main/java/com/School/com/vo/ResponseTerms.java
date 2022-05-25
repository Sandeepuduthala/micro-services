package com.School.com.vo;

import com.School.com.model.SchoolData;

public class ResponseTerms {
	
	private BookStore bookStore;
	private SchoolData data;

	public ResponseTerms() {
		super();
	}

	public ResponseTerms(BookStore bookStore, SchoolData data) {
		super();
		this.bookStore = bookStore;
		this.data = data;
	}

	public BookStore getBookStore() {
		return bookStore;
	}

	public void setBookStore(BookStore bookStore) {
		this.bookStore = bookStore;
	}

	public SchoolData getData() {
		return data;
	}

	public void setData(SchoolData data) {
		this.data = data;
	}

public class BookStore {

}

	@Override
	public String toString() {
		return "ResponseTerms [bookStore=" + bookStore + ", data=" + data + "]";
	}

}


