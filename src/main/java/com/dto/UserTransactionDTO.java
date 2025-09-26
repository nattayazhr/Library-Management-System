package com.dto;

public class UserTransactionDTO {
	private int book_id;
	private String book_title;
	private String transaction_type;
	private String transaction_date;
	
	public UserTransactionDTO(int book_id, String book_title, String transaction_type, String transaction_date) {
		super();
		this.book_id = book_id;
		this.book_title = book_title;
		this.transaction_type = transaction_type;
		this.transaction_date = transaction_date;
	}

	public int getBook_id() {
		return book_id;
	}

	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}

	public String getBook_title() {
		return book_title;
	}

	public void setBook_title(String book_title) {
		this.book_title = book_title;
	}

	public String getTransaction_type() {
		return transaction_type;
	}

	public void setTransaction_type(String transaction_type) {
		this.transaction_type = transaction_type;
	}

	public String getTransaction_date() {
		return transaction_date;
	}

	public void setTransaction_date(String transaction_date) {
		this.transaction_date = transaction_date;
	}

	@Override
	public String toString() {
		return "MyTransactionDTO [book_id=" + book_id + ", book_title=" + book_title + ", transaction_type="
				+ transaction_type + ", transaction_date=" + transaction_date + "]";
	}
}
