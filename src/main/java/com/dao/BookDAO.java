package com.dao;

import java.util.ArrayList;

import com.dto.BookDTO;
import com.model.Book;

public interface BookDAO {
	public boolean addBook(Book book);
	
	public boolean checkBook(int book_id, int user_id);
	
	public boolean deleteBook(int id);
	
	public boolean issueBook(int book_id, int user_id);
	
	public boolean returnBook(int book_id, int user_id);
	
	public BookDTO viewBook(int id);
	
	public ArrayList<BookDTO> viewAllBooks();
}
