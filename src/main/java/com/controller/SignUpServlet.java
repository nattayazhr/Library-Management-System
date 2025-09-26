package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.User;
import com.service.UserServiceImpl;
import com.util.PasswordHashUtil;

@WebServlet("/signUp")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SignUpServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/login/signUp.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		String passwordHash = PasswordHashUtil.hashPassword(password);
		
		User user = new User(name, email, passwordHash);
		
		boolean isUserAdded = new UserServiceImpl().addUser(user);
		
		request.setAttribute("isUserAdded", isUserAdded);
		
		request.getRequestDispatcher("/WEB-INF/login/signUp.jsp").forward(request, response);
		
	}

}
