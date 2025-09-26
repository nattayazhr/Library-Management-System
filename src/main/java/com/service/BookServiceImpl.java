package com.service;

import java.util.ArrayList;

import com.dao.BookDAOImpl;
import com.dto.BookDTO;
import com.model.Book;

public class BookServiceImpl implements BookService {

	@Override
	public boolean addBook(Book book) {
		return new BookDAOImpl().addBook(book);
	}

	@Override
	public boolean deleteBook(int id) {
		return new BookDAOImpl().deleteBook(id);
	}

	@Override
	public boolean issueBook(int book_id, int user_id) {
		if (!new BookDAOImpl().checkBook(book_id, user_id)) {
			return new BookDAOImpl().issueBook(book_id, user_id);
		} else {
			return false;
		}
	}

	@Override
	public boolean returnBook(int book_id, int user_id) {
		if (new BookDAOImpl().checkBook(book_id, user_id)) {
			return new BookDAOImpl().returnBook(book_id, user_id);
		} else {
			return false;
		}
	}

	@Override
	public BookDTO viewBook(int id) {
		return new BookDAOImpl().viewBook(id);
	}

	@Override
	public ArrayList<BookDTO> viewAllBooks() {
		return new BookDAOImpl().viewAllBooks();
	}

}
