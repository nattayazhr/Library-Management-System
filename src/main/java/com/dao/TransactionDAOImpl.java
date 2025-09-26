package com.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.dto.UserTransactionDTO;
import com.dto.TransactionDTO;

public class TransactionDAOImpl implements TransactionDAO {

	@Override
	public ArrayList<TransactionDTO> getTransactions() {
		ArrayList<TransactionDTO> transactions = new ArrayList<TransactionDTO>();
		
		try (Connection connection = ConnectionFactory.getConnection()) {

			Statement statement = connection.createStatement();
			String query = "SELECT bt.transaction_id, b.book_id, b.book_title,bt.user_id ,bt.transaction_type, bt.transaction_date\r\n"
					+ "FROM books b\r\n" + "JOIN book_transactions bt\r\n" + "WHERE bt.book_id = b.book_id";

			ResultSet resultSet = statement.executeQuery(query);

			while (resultSet.next()) {
				int transaction_id = resultSet.getInt("transaction_id");
				int book_id = resultSet.getInt("book_id");
				String book_title = resultSet.getString("book_title");
				String user_id = resultSet.getString("user_id");
				String transaction_type = resultSet.getString("transaction_type");

				Date sqlDate = resultSet.getDate("transaction_date"); // java.sql.Date
				String transaction_date = new SimpleDateFormat("dd-MM-yyyy").format(sqlDate);

				transactions.add(new TransactionDTO(transaction_id, book_id, book_title, user_id, transaction_type,
						transaction_date));
			}

			if (transactions.isEmpty()) {
				return null;
			} else {
				return transactions;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return transactions;
		}
	}

	@Override
	public ArrayList<UserTransactionDTO> getMyTransactions(int user_id) {
		ArrayList<UserTransactionDTO> myTransactions = new ArrayList<UserTransactionDTO>();
		
		try (Connection connection = ConnectionFactory.getConnection()) {

			String query = "SELECT b.book_id, b.book_title, bt.transaction_type, bt.transaction_date\r\n"
					+ "FROM books b\r\n" + "JOIN book_transactions bt\r\n"
					+ "WHERE bt.user_id = ? AND bt.book_id = b.book_id;";
			PreparedStatement preparedStatement = connection.prepareStatement(query);

			preparedStatement.setInt(1, user_id);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int book_id = resultSet.getInt("book_id");
				String book_title = resultSet.getString("book_title");
				String transaction_type = resultSet.getString("transaction_type");
				String transaction_date = resultSet.getString("transaction_date");

				myTransactions.add(new UserTransactionDTO(book_id, book_title, transaction_type, transaction_date));
			}

			if (myTransactions.isEmpty()) {
				return null;
			} else {
				return myTransactions;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
