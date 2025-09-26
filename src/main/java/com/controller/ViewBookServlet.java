package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.BookDTO;
import com.service.BookServiceImpl;

@WebServlet("/viewBook")
public class ViewBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ViewBookServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("/WEB-INF/view/viewBook.jsp").forward(request, response);		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		BookDTO book = new BookServiceImpl().viewBook(Integer.parseInt(id));
 
		request.setAttribute("book", book);
		request.setAttribute("isBookFound", (book != null));
		
		request.getRequestDispatcher("/WEB-INF/view/viewBook.jsp").forward(request, response);
	}

}
