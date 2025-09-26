package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.BookDTO;
import com.service.BookServiceImpl;

@WebServlet("/viewAllBook")
public class ViewAllBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ViewAllBookServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<BookDTO> books = new BookServiceImpl().viewAllBooks();
		
		request.setAttribute("books", books);
		request.setAttribute("isBookFound", !books.isEmpty());
		
		request.getRequestDispatcher("WEB-INF/view/viewAllBook.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
