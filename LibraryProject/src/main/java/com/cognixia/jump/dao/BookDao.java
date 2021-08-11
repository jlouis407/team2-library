package com.cognixia.jump.dao;

import java.util.List;

import com.cognixia.jump.model.BookModel;

public interface BookDao {
	
	public List<BookModel> getAllBooks();
	
	public BookModel getBookByIsbn(int isbn);
	
	public BookModel getBookByTitle(String title);
	
	public boolean addBook(BookModel book);
	
	public boolean deleteBook(BookModel book);
	
	public boolean editBook(BookModel book);
	
}
