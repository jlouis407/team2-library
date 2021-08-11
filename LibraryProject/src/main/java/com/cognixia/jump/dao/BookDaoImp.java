package com.cognixia.jump.dao;

import java.sql.Connection;
import java.util.List;

import com.cognixia.jump.connection.ConnectionManager;
import com.cognixia.jump.model.BookModel;

public class BookDaoImp implements BookDao{
	
	public static final Connection conn = ConnectionManager.getConnection();
	
	private static String SELECT_ALL_BOOKS = "select * from library";
	private static String SELECT_BOOK_BY_ISBN = "select * from library where isbn = ?";
	private static String SELECT_BOOK_BY_TITLE = "select * from library where title = ?";
	private static String INSERT_BOOK = "insert into library(item, qty, description) values(?, ?, ?)";
	private static String DELETE_BOOK = "delete from library where isbn = ?";
	private static String EDIT_BOOK = "update library set item = ?, qty = ?, description = ? where id = ?";
	
	@Override
	public List<BookModel> getAllBooks() {
		return null;
	}

	@Override
	public BookModel getBookByIsbn(int isbn) {
		return null;
	}

	@Override
	public BookModel getBookByTitle(String title) {
		return null;
	}

	@Override
	public boolean addBook(BookModel book) {
		return false;
	}

	@Override
	public boolean deleteBook(BookModel book) {
		return false;
	}

	@Override
	public boolean editBook(BookModel book) {
		return false;
	}

}
