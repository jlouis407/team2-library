package com.cognixia.jump.model;

public class CheckedBook {
	
	private int checkout_id;
	private int patron_id;
	private String isbn;
	private String checkedout;
	private String due_date;
	private String returned;
	
	
	public CheckedBook(int checkout_id,int patron_id, String isbn, String checkedout, String due_date, String returned) {
		super();
		checkout_id = this.checkout_id;
		patron_id = this.patron_id;
		isbn = this.isbn;
		checkedout = this.checkedout;
		due_date = this.due_date;
		returned = this.returned;
	}
	
	public int getCheckout_id() {
		return checkout_id;
	}
	public void setCheckout_id(int checkout_id) {
		this.checkout_id = checkout_id;
	}
	public int getPatron_id() {
		return patron_id;
	}
	public void setPatron_id(int patron_id) {
		this.patron_id = patron_id;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getCheckedout() {
		return checkedout;
	}
	public void setCheckedout(String checkedout) {
		this.checkedout = checkedout;
	}
	public String getDue_date() {
		return due_date;
	}
	public void setDue_date(String due_date) {
		this.due_date = due_date;
	}
	public String getReturned() {
		return returned;
	}
	public void setReturned(String returned) {
		this.returned = returned;
	}
	
	
	@Override
	public String toString() {
		return "CheckedBook [checkout_id=" + checkout_id + ", patron_id=" + patron_id + ", isbn=" + isbn
				+ ", checkedout=" + checkedout + ", due_date=" + due_date + ", returned=" + returned + "]";
	}
	
	

	

}
