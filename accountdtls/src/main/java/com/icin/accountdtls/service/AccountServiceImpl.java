package com.icin.accountdtls.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.icin.accountdtls.DAO.AccountRepo;
import com.icin.accountdtls.model.Account;
import com.icin.accountdtls.model.User;

@Service

public class AccountServiceImpl implements AccountService {

		  @Autowired
		  private AccountRepo repository;
		  @Override
		  public Account addAccount(Account account) {
			  
		    return repository.save(account);
		  }
		  @Override
		  public Account getAccountById(int id) {
		    return repository.findById(id).orElseThrow(null);
		  }
		  @Override
		  public Set<Account> getAccountByUser(User user) {
		    return repository.findByUser(user);
		  }
		  
		  @Override
		  public Set<Account> getChqReqAccounts() {
		    return repository.findChqReq();
		  }
		  
		  @Override
		  public Set<Account> getAccountByAccNo(String accno){
			 return repository.findAccByAccNo(accno); 
			  
		  }
		  
		  @Override
		  public List<Account> getAllAccount(){
		    return repository.findAll();
		  }
		  
		  @Override
		  public void updateAccount(Account account) {
		    // check if the account with the passed id exists or not
		    Account accountDB = repository.findById(account.getAccountId()).orElseThrow(null);
		    // If account exists then updated
		    repository.save(account);
		  }
		  
		  @Override
		  public void deleteAccountById(int accountId) {
		    try {
		      repository.deleteById(accountId);  
		    }catch(DataAccessException ex){
		      throw new RuntimeException(ex.getMessage());
		    }
		  }
		}