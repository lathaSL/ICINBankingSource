package com.icin.accountdtls.controller;





import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.DateDeserializers.DateDeserializer;
import com.icin.accountdtls.DAO.AccountRepo;
import com.icin.accountdtls.model.Account;
import com.icin.accountdtls.model.Beneficiary;
import com.icin.accountdtls.model.Transaction;
import com.icin.accountdtls.model.User;
import com.icin.accountdtls.service.AccountService;
import com.icin.accountdtls.service.BenService;
import com.icin.accountdtls.service.TransService;

import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@CrossOrigin
@RestController
@RequestMapping ("/account")
public class AccountController {

	Logger log=Logger.getAnonymousLogger();
	@Autowired
AccountRepo repo;
	@Autowired
	AccountService accService;
	@Autowired
	TransService transervice;
	@Autowired
	BenService benService;
	

	RestTemplate templ=new RestTemplate();
//
//	@Bean
//	public CorsFilter corsFilter() {
//	    final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//	    final CorsConfiguration config = new CorsConfiguration();
//	    config.setAllowCredentials(true);
//	    // Don't do this in production, use a proper list  of allowed origins
//	    config.setAllowedOriginPatterns(Collections.singletonList("*"));
//	    config.setAllowedHeaders(Arrays.asList("Origin", "Content-Type", "Accept"));
//	    config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "OPTIONS", "DELETE", "PATCH"));
//	    source.registerCorsConfiguration("/**", config);
//	    return new CorsFilter(source);
//	}

	@GetMapping
	public List<Account> getAccountDetails(){
		
		return repo.findAll();
	}
@RequestMapping("/{primacc}/{sbacc}")
public Set<Account> getAccountInfo(@PathVariable("primacc") String primacc,@PathVariable("sbacc") String sbacc,HttpServletRequest req,HttpServletResponse res) {
	
	
		return repo.findAccounts(primacc, sbacc);	
		
//		if(repo.findByNamePassword(user, password,role)!=null) {
//			
//			return "valid";
//		}
//		else {
//			return "invalid";
//		}
			
	}

	@CrossOrigin
	@PostMapping("/transfer")
	public String updateAccount(HttpServletRequest req,HttpServletResponse res) {
		double amount=Double.parseDouble(req.getParameter("amount"));
		Account acc=repo.getById(Integer.parseInt(req.getParameter("acc_id")));
		Beneficiary ben;
		
		Transaction trans;
				
		if (req.getParameter("type").equalsIgnoreCase("deposit")) {
			acc.setBalance(acc.getBalance()+amount);
			
				 trans=new Transaction(acc, acc.getType(), acc.getBalance(), amount,  new Date(),"",
							acc.getAccountNo(),"Deposit");
			

			}
		else {
			acc.setBalance(acc.getBalance() - amount);
			if (req.getParameter("benac_id") !=null && req.getParameter("benac_id")!="") {
				ben=benService.getBenefById(Integer.parseInt(req.getParameter("benac_id")));
				 trans=new Transaction(acc, acc.getType(), acc.getBalance(), amount,  new Date(),
							acc.getAccountNo(),ben.getBenAcNo(),"Transfer");
			}
			else {
			 trans=new Transaction(acc, acc.getType(), acc.getBalance(), amount,  new Date(),
					acc.getAccountNo(),"","Withdrawl");
			}
		}
		
		accService.updateAccount(acc);
		transervice.addTrans(trans);
		return "completed";
		
	}
//	@RequestMapping ("login")
//	public String loginValidate(@RequestBody User user) {
////		String userName=req.getParameter("userName");
////		String password=req.getParameter("password");
////		String role=req.getParameter("role");
////		System.out.println(userName + role+"    n "+repo.findByNamePassword(userName, password,role));
//		
////		return userService.getUserById(user.getUserId());
////		return repo.findByNamePassword(userName, password,role);	
//		
//		if(userService.getUserById(user.getUserId()) !=null) {
//			
//			return "valid";
//		}
//		else {
//			return "invalid";
//		}
//			
//	}
	@GetMapping("/search/{accno}")
	public Set<Account> getAccountDtlsByAccNo(@PathVariable("accno") String accno){
		
		return accService.getAccountByAccNo(accno);
		
	}
	
	@PostMapping("/access")
	public String updateAccess(HttpServletRequest req,HttpServletResponse res) {
		
		Account acc=repo.getById(Integer.parseInt(req.getParameter("acc_id")));
		if (req.getParameter("access").equals("grant")){
			acc.setAccessLevel("Operational");
		}
		else {
			acc.setAccessLevel("Blocked");

		}
		accService.updateAccount(acc);

		return "access modified";
	}
	
	
@GetMapping("/{id}")
public Set<Account> getAccountDtls(@PathVariable("id") int id){
	String url="http://localhost:8999/user/find/"+id;
	User user=templ.getForObject(url,User.class);

	return accService.getAccountByUser(user);
	
}


@GetMapping("/transaction/{id}")
public Set<Transaction> getTransDtls(@PathVariable("id") int id){


return transervice.getAllTransByAcc(accService.getAccountById(id));

}

@GetMapping("/chq/{id}")
public String reqChqBook(@PathVariable("id") int id){
	String url="http://localhost:8999/user/find/"+id;
	User user=templ.getForObject(url,User.class);
	Set<Account> accounts=accService.getAccountByUser(user);
	for (Account acc:accounts ) {
		acc.setChqBkReqStat("true");
		accService.updateAccount(acc);
	}
	return "Requested";
}
	@GetMapping("/chqreq")
	public Set<Account> pendingChqReq(){	

	return accService.getChqReqAccounts();
	
}
	@GetMapping("/chqreq/{id}")
	public String reqChqBookApprove(@PathVariable("id") int id){
		Account account=accService.getAccountById(id);
			account.setChqBkReqStat("false");
			accService.updateAccount(account);
		
		return "Approved";
	}

@RequestMapping("/{user}/{primacc}/{sbacc}")
public String updateAccountInfo(@PathVariable("user") String userstr,
		@PathVariable("primacc") String primacc,@PathVariable("sbacc") String sbacc,
		HttpServletRequest req,HttpServletResponse res) throws JsonMappingException, JsonProcessingException {
	final User user = new ObjectMapper()
            .readValue(userstr, User.class);
	
	
		Set<Account> accounts= repo.findAccounts(primacc, sbacc);	
		for (Account account: accounts) {
			account.setUser(user);
			accService.updateAccount(account);
		}
		return "success";
		
		
//	
	
	}

@PostMapping("createacc")
@ResponseStatus(HttpStatus.CREATED)
//@PostMapping("upd")
//public String updateUser(HttpServletRequest req,HttpServletResponse res) {
//	try {
//		userService.updateUser(Integer.parseInt(req.getParameter("id")), req.getParameter("newpassword"));
//		System.out.println(new ResponseEntity<String>(HttpStatus.OK));
//		return "Password changed";
public String addAccount(HttpServletRequest req,HttpServletResponse res) {
	
	String url="http://localhost:8999/user/"+req.getParameter("user_id");
	String accLevel="RW";
//	
//	String url="http://localhost:8999/account/\"userId="+user.getUserId()+"&loginName="+user.getLoginName()
//	+"&password="+user.getPassword()+"&role="+user.getRole()+"\"/"+primAccNo+"/"+secAccNo;
	
//	String url="http://localhost:8999/account/"+user.getUserId()+"/"+primAccNo+"/"+secAccNo;
	if (req.getParameter("accessLevel").equalsIgnoreCase("true")) {
		accLevel="R";
				
	}
	
	Account acc=new Account(req.getParameter("accountNo"), 
			req.getParameter("acctype"),Double.parseDouble(req.getParameter("balance")), 
			req.getParameter("chqBkReqStat"),accLevel);
	
	
	
	User user=templ.getForObject(url,User.class);

		acc.setUser(user);
	 accService.addAccount(acc);
//	 accService.updateAccount(acc);
	 return "success";
	
}

@GetMapping ("/beneficiary/list")
public List<Beneficiary> getBeneficiaryDtls(){
	

	return benService.getAllBenef();
	
}

@PostMapping ("/beneficiary/add")
public String AddBeneficiaryDtls(HttpServletRequest req,HttpServletResponse res){
	String url="http://localhost:8999/user/find/"+req.getParameter("user_id");
	User user=templ.getForObject(url,User.class);

	Beneficiary ben= new Beneficiary(req.getParameter("name"),
			req.getParameter("accountno"),req.getParameter("ifsc"));
	ben.setUser(user);
	benService.addBenef(ben);

	return "added";
	
}
@RequestMapping("/beneficiary/{id}")
public String deleteBeneficiary(@PathVariable("id") int id) {
	benService.deleteBenefById(id);
	return "deleted";
}
	
}