package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.UserDTO;
import com.service.UserServiceImpl;

@WebServlet("/getUsers")
public class GetUsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public GetUsersServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<UserDTO> users = new UserServiceImpl().getUsers();
		
		request.setAttribute("users", users);
		request.setAttribute("isUserFound", (users != null));
		
		request.getRequestDispatcher("WEB-INF/view/viewUsers.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
