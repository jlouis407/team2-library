package com.cognixia.jump.model;

public class BookModel {

	private int isbn;
	private String title;
	private String description;
	private String dateAdded;
	private boolean checkedOut;
	
	public BookModel(int isbn, String title, String description, String dateAdded, boolean checkedOut) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.description = description;
		this.dateAdded = dateAdded;
		this.checkedOut = false; 
	}
	
	public int getIsbn() {
		return isbn;
	}
	
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String d) {
		this.description = d;
	}
	
	public String getDate() {
		return dateAdded;
	}
	
	public void setDate(String year,String month,String day) {
		this.title = year+month+day;
	}
	
	public boolean checkedOut() {
		return checkedOut;
	}
	
	public String toString() {
		return "Product [isbn=" + isbn + ", Title=" + title + ", Description=" + description + ", Date=" + dateAdded + "]";
	}
}
