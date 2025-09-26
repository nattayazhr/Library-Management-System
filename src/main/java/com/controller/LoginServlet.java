package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.UserLoginDTO;
import com.dto.UserSessionDTO;
import com.service.UserServiceImpl;
import com.util.PasswordHashUtil;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/login/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		String passwordHash = PasswordHashUtil.hashPassword(password);
		
		UserLoginDTO user = new UserLoginDTO(email, passwordHash);
		
		UserSessionDTO userSession = new UserServiceImpl().login(user);

		if(userSession != null) {
			HttpSession session = request.getSession();
			session.setAttribute("user", userSession);
			
			response.sendRedirect("home");
		} else {
			request.setAttribute("errorMessage", "Invalid credentials");
			request.getRequestDispatcher("/WEB-INF/login/login.jsp").forward(request, response);
		}
		
	}

}
