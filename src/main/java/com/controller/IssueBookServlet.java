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

@WebServlet("/issue")
public class IssueBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public IssueBookServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("/WEB-INF/view/issueBook.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		
		String id = request.getParameter("id");
		UserSessionDTO user = (UserSessionDTO) session.getAttribute("user");
		int user_name = user.getUser_id();
		
		boolean isBookIssued = new BookServiceImpl().issueBook(Integer.parseInt(id), user_name);
		
		session.setAttribute("isBookIssued", isBookIssued);
		session.setAttribute("bookId", id);
		
		response.sendRedirect("issue");
	}

}
