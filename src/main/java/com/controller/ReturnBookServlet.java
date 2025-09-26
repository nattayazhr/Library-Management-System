package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.UserSessionDTO;
import com.service.BookServiceImpl;

@WebServlet("/return")
public class ReturnBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ReturnBookServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/view/returnBook.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String id = request.getParameter("id");
		UserSessionDTO user = (UserSessionDTO) session.getAttribute("user");
		int user_id = user.getUser_id();
		
		boolean isBookReturned = new BookServiceImpl().returnBook(Integer.parseInt(id), user_id);
		
		session.setAttribute("isBookReturned", isBookReturned);
		session.setAttribute("bookId", id);
		
		response.sendRedirect("return");
	}

}
