package com.icin.accountdtls.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import com.icin.accountdtls.model.Account;


@Entity
public class Beneficiary {


	@Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int benId;
	

	@ManyToOne(cascade=CascadeType.MERGE)
    @JoinColumn(name="user_id")
    private User user;
	
	private String benName;
	private String benAcNo;
	private String benIFSCCode;
	public int getBenId() {
		return benId;
	}
	public void setBenId(int benId) {
		this.benId = benId;
	}
//	public Account getAccount() {
//		return account;
//	}
//	public void setAccount(Account account) {
//		this.account = account;
//	}
	public String getBenName() {
		return benName;
	}
	public void setBenName(String benName) {
		this.benName = benName;
	}
	public String getBenAcNo() {
		return benAcNo;
	}
	public void setBenAcNo(String benAcNo) {
		this.benAcNo = benAcNo;
	}
	
	public String getBenIFSCCode() {
		return benIFSCCode;
	}
	public Beneficiary( String benName, String benAcNo,  String benIFSCCode) {
		super();
		this.benName = benName;
		this.benAcNo = benAcNo;
		this.benIFSCCode = benIFSCCode;		
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public void setBenIFSCCode(String benIFSCCode) {
		this.benIFSCCode = benIFSCCode;
	}
	
	public Beneficiary() {
		super();
	}
}
