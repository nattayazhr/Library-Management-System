package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.TransactionDTO;
import com.service.TransactionServiceImpl;

@WebServlet("/allTransactions")
public class GetAllTransactionsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public GetAllTransactionsServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<TransactionDTO> transactions = new TransactionServiceImpl().getTransactions();
		
		request.setAttribute("transactions", transactions);
		request.setAttribute("isTransactionFound", (transactions != null));
		
		request.getRequestDispatcher("WEB-INF/view/viewTransactions.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
