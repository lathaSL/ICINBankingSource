package com.icin.accountdtls.DAO;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.icin.accountdtls.model.Account;
import com.icin.accountdtls.model.User;

public interface AccountRepo extends JpaRepository<Account, Integer>{ 

	@Query("select acc from Account acc where (acc.accountNo=?1 and acc.type='primary')or (acc.accountNo=?2 and acc.type='savings')")
	public Set<Account> findAccounts(String primacc, String sbacc);
	
	@Query("select acc from Account acc where (acc.user=?1)")
	public Set<Account> findByUser(User user);
	
	@Query("select acc from Account acc where (acc.chqBkReqStat='true')")
	public Set<Account> findChqReq();
	
	@Query("select acc from Account acc where (acc.accountNo=?1)")
	public Set<Account> findAccByAccNo(String accno);
}

