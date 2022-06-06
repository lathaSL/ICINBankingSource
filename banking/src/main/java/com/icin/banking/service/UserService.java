package com.icin.banking.service;

import java.util.List;

import com.icin.banking.model.User;
import com.icin.banking.model.UserDtls;


public interface UserService {
	User addUser(User user);
	UserDtls addUserDetails(UserDtls userDtls);

	  User getUserById(int userId);
	  void updateUser(int userId, String newpassword);
	  void deleteUserById(int userId);
	  List<User> getAllUsers();

}
