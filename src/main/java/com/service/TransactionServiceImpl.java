package com.service;

import java.util.ArrayList;

import com.dao.TransactionDAOImpl;
import com.dto.UserTransactionDTO;
import com.dto.TransactionDTO;

public class TransactionServiceImpl implements TransactionService {

	@Override
	public ArrayList<TransactionDTO> getTransactions() {
		return new TransactionDAOImpl().getTransactions();
	}

	@Override
	public ArrayList<UserTransactionDTO> getMyTransactions(int user_id) {
		return new TransactionDAOImpl().getMyTransactions(user_id);
	}

}
