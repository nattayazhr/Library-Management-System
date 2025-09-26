package com.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.dto.BookDTO;
import com.model.Book;

public class BookDAOImpl implements BookDAO {

	@Override
	public boolean addBook(Book book) {
		try (Connection connection = ConnectionFactory.getConnection()) {

			String query = "INSERT INTO books (book_title, book_author, book_price) VALUES(?, ?, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(query);

			preparedStatement.setString(1, book.getTitle());
			preparedStatement.setString(2, book.getAuthor());
			preparedStatement.setBigDecimal(3, book.getPrice());

			int rowsAffected = preparedStatement.executeUpdate();

			return rowsAffected > 0;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean checkBook(int book_id, int user_id) {

		try (Connection connection = ConnectionFactory.getConnection()) {
			
			String query = "SELECT \r\n"
					+ "COALESCE(SUM(CASE WHEN transaction_type = 'ISSUED' THEN 1 ELSE 0 END), 0) AS issues,\r\n"
					+ "COALESCE(SUM(CASE WHEN transaction_type = 'RETURNED' THEN 1 ELSE 0 END), 0) AS returns\r\n"
					+ "FROM book_transactions\r\n"
					+ "WHERE book_id = ? AND user_id = ?";

			PreparedStatement preparedStatementIssue = connection.prepareStatement(query);
			preparedStatementIssue.setInt(1, book_id);
			preparedStatementIssue.setInt(2, user_id);

			ResultSet resultSet = preparedStatementIssue.executeQuery();

			if (resultSet.next()) {
				int issues = resultSet.getInt("issues");
				int returns = resultSet.getInt("returns");
				
				return issues - returns == 1;
			}
			
			return false;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteBook(int id) {
		try (Connection connection = ConnectionFactory.getConnection()) {

			String query = "DELETE FROM books WHERE book_id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);

			preparedStatement.setInt(1, id);

			int rowsAffected = preparedStatement.executeUpdate();

			return rowsAffected > 0;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean issueBook(int book_id, int user_id) {
		try (Connection connection = ConnectionFactory.getConnection()) {
			String query = "INSERT INTO book_transactions(book_id, user_id, transaction_type) VALUES(?, ? , 'ISSUED')";
			PreparedStatement preparedStatement = connection.prepareStatement(query);

			preparedStatement.setInt(1, book_id);
			preparedStatement.setInt(2, user_id);

			int rowsAffected = preparedStatement.executeUpdate();

			return rowsAffected > 0;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean returnBook(int book_id, int user_id) {
		try (Connection connection = ConnectionFactory.getConnection()) {

			String query = "INSERT INTO book_transactions(book_id, user_id, transaction_type) VALUES(?, ?, 'RETURNED')";
			PreparedStatement preparedStatement = connection.prepareStatement(query);

			preparedStatement.setInt(1, book_id);
			preparedStatement.setInt(2, user_id);

			int rowsAffected = preparedStatement.executeUpdate();

			return rowsAffected > 0;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public BookDTO viewBook(int id) {
		try (Connection connection = ConnectionFactory.getConnection()) {

			String query = "SELECT book_id, book_title, book_author, book_price FROM books WHERE book_id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);

			preparedStatement.setInt(1, id);

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				int book_id = resultSet.getInt("book_id");
				String title = resultSet.getString("book_title");
				String author = resultSet.getString("book_author");
				BigDecimal price = resultSet.getBigDecimal("book_price");
				return new BookDTO(book_id, title, author, price);
			} else {
				return null;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public ArrayList<BookDTO> viewAllBooks() {
		ArrayList<BookDTO> books = new ArrayList<BookDTO>();
		
		try (Connection connection = ConnectionFactory.getConnection()) {

			Statement statement = connection.createStatement();
			String query = "SELECT book_id, book_title, book_author, book_price FROM books";

			ResultSet resultSet = statement.executeQuery(query);

			while (resultSet.next()) {
				int id = resultSet.getInt("book_id");
				String title = resultSet.getString("book_title");
				String author = resultSet.getString("book_author");
				BigDecimal price = resultSet.getBigDecimal("book_price");

				books.add(new BookDTO(id, title, author, price));
			}
			
			return books;

		} catch (Exception e) {
			e.printStackTrace();
			return books;
		}
	}

}
