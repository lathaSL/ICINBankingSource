package com.icin.accountdtls.service;

import java.util.List;
import java.util.Set;

import com.icin.accountdtls.model.Account;
import com.icin.accountdtls.model.User;

public interface AccountService {


	Account addAccount(Account account);
	Account getAccountById(int id);
	Set<Account> getAccountByUser(User user);
	Set<Account> getChqReqAccounts();
	  void updateAccount(Account account);
	  void deleteAccountById(int accountId);
	  Set <Account> getAccountByAccNo(String accno);
	  List<Account> getAllAccount();
}
