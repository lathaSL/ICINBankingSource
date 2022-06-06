package com.icin.banking.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.icin.banking.model.User;

public interface UserRepo extends JpaRepository<User, Integer>{

	@Query("select userId from User user where user.loginName=?1 and user.password=?2 and user.role=?3")
	public String findByNamePassword(String name, String pwd, String role);
	
}