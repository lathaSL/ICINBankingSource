package com.icin.accountdtls.DAO;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.icin.accountdtls.model.Account;
import com.icin.accountdtls.model.Transaction;

public interface TransRepo extends JpaRepository<Transaction, Integer>{

	@Query("select trans from Transaction trans where (trans.account=?1)")

	Set<Transaction> findByAcc(Account acc); 

}
