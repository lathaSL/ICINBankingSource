package com.icin.accountdtls.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.icin.accountdtls.model.Account;



@Entity
public class User {
	@Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	private String loginName;	
	private String role;
	private String password;
	
//	@OneToOne(cascade=CascadeType.ALL)
//	@JoinColumn(name="userDtlsId")
//	private UserDtls userdtls;
	
//	@OneToMany(mappedBy="user")
//    private Set<Account> acc = new HashSet();
//	
//	public Set<Account> getAcc() {
//		return this.acc;
//	}
//	public void addAcc(Account acc) {
//		this.acc.add(acc);
//	}
//	public void removeAcc(Account acc) {
//		this.acc.remove(acc);
//	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public User() {
		super();
	}
	public User(String loginName, String password,String role) {
		super();
		this.role = role;
		this.password = password;
		this.loginName = loginName;		
//		this.userdtls=userdtls;
		
	}
//	public UserDtls getUserdtls() {
//		return userdtls;
//	}
//	public void setUserdtls(UserDtls userdtls) {
//		this.userdtls = userdtls;
//	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", loginName=" + loginName + ", role=" + role + ", password=" + password
				+ "]";
	}

	 
	

}
