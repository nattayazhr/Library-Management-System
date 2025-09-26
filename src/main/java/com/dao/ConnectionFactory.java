package com.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class ConnectionFactory {

	private static HikariDataSource hikariDataSource;

//	on the project startUp using the listener
	public static void init(String url, String user, String password) {

		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");

			HikariConfig hikariConfig = new HikariConfig();

			hikariConfig.setJdbcUrl(url);
			hikariConfig.setUsername(user);
			hikariConfig.setPassword(password);

			hikariConfig.setMinimumIdle(20);
			hikariConfig.setMaximumPoolSize(100);

			hikariDataSource = new HikariDataSource(hikariConfig);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

//	To get the connection from the connection pool
	public static Connection getConnection() throws SQLException {
		return hikariDataSource.getConnection();
	}
	
//	On the close of project using listener
	public static void close() {
        if (hikariDataSource != null && !hikariDataSource.isClosed()) {
            hikariDataSource.close();
            System.out.println("HikariDataSource has been shut down.");
        }
    }

}
