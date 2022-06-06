package com.icin.banking.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



@Entity
public class Account {
	@Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int accountId;
	private String accountNo;
	private String type;
	private double balance;
	private String chqBkReqStat;
	private String accessLevel;

    public String getAccessLevel() {
		return accessLevel;
	}
	public void setAccessLevel(String accessLevel) {
		this.accessLevel = accessLevel;
	}

	@ManyToOne(cascade=CascadeType.MERGE)
    
    @JoinColumn(name="user_id")
    private User user;

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getChqBkReqStat() {
		return chqBkReqStat;
	}
	public void setChqBkReqStat(String chqBkReqStat) {
		this.chqBkReqStat = chqBkReqStat;
	}
	public Account(String accountNo, String type, double balance, String chqBkReqStat, String accessLevel) {
		super();
		this.accountNo = accountNo;
		this.type = type;
		this.balance = balance;
		this.chqBkReqStat = chqBkReqStat;
		this.accessLevel=accessLevel;
	}	
	
	public Account() {
		super();
	}
}
