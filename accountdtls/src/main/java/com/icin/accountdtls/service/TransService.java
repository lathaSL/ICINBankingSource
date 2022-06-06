package com.icin.accountdtls.service;

import java.util.List;
import java.util.Set;

import com.icin.accountdtls.model.Account;
import com.icin.accountdtls.model.Transaction;


public interface TransService {

	Transaction addTrans(Transaction trans);
	Transaction getTransById(int transId);
	Set<Transaction> getAllTransByAcc(Account acc);
	  void updateTrans(Transaction trans);
	  void deleteTransById(int transId);
	  List<Transaction> getAllTrans();

}