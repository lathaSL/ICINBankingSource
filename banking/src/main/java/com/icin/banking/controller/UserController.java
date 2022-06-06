package com.icin.banking.controller;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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

import com.icin.banking.DAO.UserRepo;
import com.icin.banking.model.Account;
import com.icin.banking.model.User;
import com.icin.banking.model.UserDtls;
import com.icin.banking.service.UserService;
 @CrossOrigin(origins = "http://localhost:8999")
@RestController
@RequestMapping ("/user")
public class UserController {
	Logger log=Logger.getAnonymousLogger();
	@Autowired
	UserRepo repo;
	@Autowired
	UserService userService;
	RestTemplate templ=new RestTemplate();
	
	@RequestMapping ("login")
	public String loginValidate(HttpServletRequest req,HttpServletResponse res) {
		String userName=req.getParameter("userName");
		String password=req.getParameter("password");
		String role=req.getParameter("role");
		System.out.println(userName + role+"    n "+repo.findByNamePassword(userName, password,role));
		return repo.findByNamePassword(userName, password,role);	
		
//		if(repo.findByNamePassword(user, password,role)!=null) {
//			
//			return "valid";
//		}
//		else {
//			return "invalid";
//		}
			
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
	
	@PostMapping("/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public User addUser(@RequestBody User user) {
		return userService.addUser(user);
	}
	
	@RequestMapping("/find/{id}")
	public User findUser(@PathVariable(value="id") int userid) {
		return userService.getUserById(userid);
	}
	
//	@PostMapping("register")
//	@ResponseStatus(HttpStatus.CREATED)
//	public UserDtls addUserDetails(@RequestBody UserDtls userDtls) {
//		return userService.addUserDetails(userDtls);
//	}
	//Update user record
		@PostMapping("upd")
		public String updateUser(HttpServletRequest req,HttpServletResponse res) {
			try {
				userService.updateUser(Integer.parseInt(req.getParameter("id")), req.getParameter("newpassword"));
				System.out.println(new ResponseEntity<String>(HttpStatus.OK));
				return "Password changed";
			} catch (NoSuchElementException ex) {
				// log the error message
				System.out.println(ex.getMessage());
				return "Error occurred";
			}
		}
	
	@PostMapping("register")
	public int registerUser(HttpServletRequest req,HttpServletResponse res) {
		String email=req.getParameter("email");
		String firstName=req.getParameter("firstname");
		String lastName=req.getParameter("lastname");
		String phoneNo=req.getParameter("phoneno");
//		Date dob=new Date(req.getParameter("dob"));
//		String role=req.getParameter("role");
		String primAccNo=req.getParameter("primaccno");
		String secAccNo=req.getParameter("secaccno");
		String address=req.getParameter("address");
		String zipCode=req.getParameter("zipcode");
		
//		String url="http://localhost:8999/account/"+primAccNo+"/"+secAccNo;
//		Set<Account> acc=templ.getForObject(url,Set.class);

		
	// addcredential
			String username=req.getParameter("username");
			String password=req.getParameter("password");
			String role=req.getParameter("role");

			User user=new User(username,password, role );
			user=userService.addUser(user);

		
		UserDtls userdtls=new UserDtls(firstName,lastName,email, phoneNo, zipCode,user,null, address);
		userService.addUserDetails(userdtls);
		String userstr="{\"userId\":"+user.getUserId()+",\"loginName\":\""+user.getLoginName()
		+"\",\"password\":\""+user.getPassword()+"\",\"role\":\""+user.getRole()+"\"}";
//		
		String url="http://localhost:8999/account/{userstr}/"+primAccNo+"/"+secAccNo;
//		
//		String url="http://localhost:8999/account/\"userId="+user.getUserId()+"&loginName="+user.getLoginName()
//		+"&password="+user.getPassword()+"&role="+user.getRole()+"\"/"+primAccNo+"/"+secAccNo;
		
//		String url="http://localhost:8999/account/"+user.getUserId()+"/"+primAccNo+"/"+secAccNo;
		
		
		String resp=templ.getForObject(url,String.class,userstr);


		return 1;
		
	}
}
	
