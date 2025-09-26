package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.dto.UserDTO;
import com.dto.UserLoginDTO;
import com.dto.UserSessionDTO;
import com.model.User;

public class UserDAOImpl implements UserDAO {

	@Override
	public boolean addUser(User user) {
		try (Connection connection = ConnectionFactory.getConnection()) {

			String query = "INSERT INTO users(user_name, email, password_hash) values(?, ?, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(query);

			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getEmail());
			preparedStatement.setString(3, user.getPassword());

			int rowsAffected = preparedStatement.executeUpdate();

			if (rowsAffected > 0) {
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public ArrayList<UserDTO> getUsers() {
		ArrayList<UserDTO> users = new ArrayList<UserDTO>();
		
		try (Connection connection = ConnectionFactory.getConnection()) {

			Statement statement = connection.createStatement();
			String query = "SELECT user_id, user_name, email FROM users WHERE role = 'USER'";

			ResultSet resultSet = statement.executeQuery(query);

			while (resultSet.next()) {
				String user_id = resultSet.getString("user_id");
				String user_name = resultSet.getString("user_name");
				String email = resultSet.getString("email");

				users.add(new UserDTO(user_id, user_name, email));
			}
			if (users.isEmpty()) {
				return null;
			} else {
				return users;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return users;
		}
	}

	@Override
	public UserSessionDTO login(UserLoginDTO user) {
		try (Connection connection = ConnectionFactory.getConnection()) {

			String query = "SELECT user_id, user_name, role FROM users WHERE email = ? AND password_hash = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);

			preparedStatement.setString(1, user.getEmail());
			preparedStatement.setString(2, user.getPassword());

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				int user_id = resultSet.getInt("user_id");
				String user_name = resultSet.getString("user_name");
				String role = resultSet.getString("role");
				return new UserSessionDTO(user_id, user_name, role);
			} else {
				return null;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
