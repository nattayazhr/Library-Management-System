package com.service;

import java.util.ArrayList;

import com.dto.UserTransactionDTO;
import com.dto.TransactionDTO;

public interface TransactionService {
	public ArrayList<TransactionDTO> getTransactions();
	
	public ArrayList<UserTransactionDTO> getMyTransactions(int user_id);
}
