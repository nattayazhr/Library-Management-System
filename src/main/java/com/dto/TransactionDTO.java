package com.dto;

public class TransactionDTO {
	private int transaction_id;
	private int book_id;
	private String book_title;
	private String user_id;
	private String transaction_type;
	private String transaction_date;
	
	public TransactionDTO(int transaction_id, int book_id, String book_title, String user_id, String transaction_type,
			String transaction_date) {
		super();
		this.transaction_id = transaction_id;
		this.book_id = book_id;
		this.book_title = book_title;
		this.user_id = user_id;
		this.transaction_type = transaction_type;
		this.transaction_date = transaction_date;
	}

	public int getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(int transaction_id) {
		this.transaction_id = transaction_id;
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

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
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
		return "TransactionDTO [transaction_id=" + transaction_id + ", book_id=" + book_id + ", book_title="
				+ book_title + ", user_id=" + user_id + ", transaction_type=" + transaction_type + ", transaction_date="
				+ transaction_date + "]";
	}
		
}
