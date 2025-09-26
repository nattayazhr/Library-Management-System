package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.UserTransactionDTO;
import com.dto.UserSessionDTO;
import com.service.TransactionServiceImpl;


@WebServlet("/myTransactions")
public class GetUserTransactionsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetUserTransactionsServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		UserSessionDTO user = (UserSessionDTO) session.getAttribute("user");
		int user_id = user.getUser_id();
		
		ArrayList<UserTransactionDTO> myTransactions = new TransactionServiceImpl().getMyTransactions(user_id);
		
		request.setAttribute("myTransactions", myTransactions);
		request.setAttribute("isTransactionFound", (myTransactions != null));
		
		request.getRequestDispatcher("WEB-INF/view/myTransactions.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
