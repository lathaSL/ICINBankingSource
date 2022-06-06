package com.icin.accountdtls.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.icin.accountdtls.DAO.TransRepo;
import com.icin.accountdtls.model.Account;
import com.icin.accountdtls.model.Transaction;

@Service
public class TransServiceImpl implements TransService {
	  @Autowired
	  private TransRepo repository;
	  @Override
	  public Transaction addTrans(Transaction trans) {
	    return repository.save(trans);
	  }
	  @Override
	  public Transaction getTransById(int transId) {
	    return repository.findById(transId).get();
	  }
	  @Override
	  public List<Transaction> getAllTrans(){
	    return repository.findAll();
	  }
	  @Override
	  public Set<Transaction> getAllTransByAcc(Account acc){
	    return repository.findByAcc(acc);
	  }
	  
	  @Override
	  public void updateTrans(Transaction trans) {
	    // check if the trans with the passed id exists or not
	    Transaction transDB = repository.findById(trans.getTransId()).orElseThrow(null);
	    // If trans exists then updated
	    repository.save(trans);
	  }
	  
	  @Override
	  public void deleteTransById(int transId) {
	    try {
	      repository.deleteById(transId);  
	    }catch(DataAccessException ex){
	      throw new RuntimeException(ex.getMessage());
	    }
	  }
	}