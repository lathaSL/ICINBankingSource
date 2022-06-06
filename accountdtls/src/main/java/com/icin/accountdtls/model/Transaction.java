package com.icin.accountdtls.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import com.icin.accountdtls.model.Account;


@Entity
public class Transaction {
	public int getTransId() {
		return transId;
	}

	public void setTransId(int transId) {
		this.transId = transId;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
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

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Date getTransDate() {
		return transDate;
	}

	public void setTransDate(Date transDate) {
		this.transDate = transDate;
	}

	public String getFromAC() {
		return fromAC;
	}

	public void setFromAC(String fromAC) {
		this.fromAC = fromAC;
	}

	public String getToAC() {
		return toAC;
	}

	public void setToAC(String toAC) {
		this.toAC = toAC;
	}

	public String getDetails() {
		return Details;
	}

	public void setDetails(String details) {
		Details = details;
	}

	@Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int transId;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="accountId")
	private Account account;
	private String type;
	private double balance;
	private double amount;
	private Date transDate;
	private String fromAC;
	private String toAC;
	private String Details;
	
	public Transaction(Account account, String type, double balance, double amount, Date transDate, String fromAC,
			String toAC, String details) {
		super();
		this.account = account;
		this.type = type;
		this.balance = balance;
		this.amount = amount;
		this.transDate = transDate;
		this.fromAC = fromAC;
		this.toAC = toAC;
		Details = details;
	}

	public Transaction() {
		super();
	}
}
