package com.controller;

import java.io.IOException;

import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.Book;
import com.service.BookServiceImpl;


@WebServlet("/addBook")
public class AddBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AddBookServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/view/addBook.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String price = request.getParameter("price");
		BigDecimal bPrice = null;
		
		HttpSession session = request.getSession(false);
		try {
			bPrice = new BigDecimal(price);
		} catch(NumberFormatException e) {
			e.printStackTrace();
			session.setAttribute("isBookAdded", false);
		}
		
		Book book = new Book(title, author, bPrice);
		
		boolean addedBook = new BookServiceImpl().addBook(book);
		
		session.setAttribute("isBookAdded", addedBook);
		
		response.sendRedirect("addBook");
	}

}
