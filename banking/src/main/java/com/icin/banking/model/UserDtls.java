package com.icin.banking.model;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.icin.banking.model.Account;



@Entity
public class UserDtls {
	@Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userDtlsId;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNo;
	private String zipCode;
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="userId")
	private User user;

////	@OneToMany(mappedBy="accountNo")
//	@OneToOne(cascade=CascadeType.ALL)
//	@JoinColumn(name="primaccid")
//	private Account primacc;
//	
//	@OneToOne(cascade=CascadeType.ALL)
//	@JoinColumn(name="secaccid", insertable = false, updatable = false)
//	private Account sbacc;
	
//	@OneToMany(mappedBy="userdtls")
//    private Set<Account> acc = new HashSet();
////	
//	@OneToMany(mappedBy="accountId", cascade = CascadeType.ALL)
//	private List<Account> acc;
//	
	private String address;
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getUserId() {
		return userDtlsId;
	}
	public void setUserId(int userId) {
		this.userDtlsId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getPhoneNo() {
		return phoneNo;
	}
	public UserDtls() {
		super();
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public UserDtls(String firstName, String lastName, String email, String phoneNo, String zipCode, User user,
		Set<Account>acc, String address) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNo = phoneNo;
		this.zipCode = zipCode;
		this.user = user;
//		this.acc = acc;
		this.address = address;
	}
	@Override
	public String toString() {
		return "UserDtls [userDtlsId=" + userDtlsId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", phoneNo=" + phoneNo +  ", address=" + address
				+ "]";
	}
//	public UserDtls(String firstName, String lastName, String email, String phoneNo, String zipCode, String address) {
//		super();
//		this.firstName = firstName;
//		this.lastName = lastName;
//		this.email = email;
//		this.phoneNo = phoneNo;
//		this.zipCode = zipCode;
//		this.address = address;
//	}
	public int getUserDtlsId() {
		return userDtlsId;
	}
	public void setUserDtlsId(int userDtlsId) {
		this.userDtlsId = userDtlsId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
//	public Account getPrimAccounts() {
//		return primacc;
//	}
//	public void setPrimAccounts(Account primacc) {
//		this.primacc = primacc;
//	}
//	public Account getSbAccounts() {
//		return sbacc;
//	}
//	public void setSbAccounts(Account sbacc) {
//		this.sbacc = sbacc;
//	}
//	
//	public Set<Account> getAcc() {
//		return acc;
//	}
//	public void setAcc(Set<Account> acc) {
//		this.acc = acc;
//	}
//	 
	

}
