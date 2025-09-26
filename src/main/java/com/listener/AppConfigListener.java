package com.listener;

import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.dao.ConnectionFactory;

@WebListener
public class AppConfigListener implements ServletContextListener {

	public AppConfigListener() {
		
	}

	public void contextDestroyed(ServletContextEvent sce) {
//		Closing the hikari connection pool
		ConnectionFactory.close();
	}

	public void contextInitialized(ServletContextEvent sce) {
		try (InputStream input = sce.getServletContext().getResourceAsStream("/WEB-INF/config/config.properties")) {

			Properties properties = new Properties();
			properties.load(input);

			String url = properties.getProperty("db.url");
			String user = properties.getProperty("db.user");
			String password = properties.getProperty("db.password");
			
//			To initialize the connection pool using hikari
			ConnectionFactory.init(url, user, password);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
