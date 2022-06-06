package com.icin.banking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.icin.banking.DAO.UserDetailsRepo;
import com.icin.banking.DAO.UserRepo;
import com.icin.banking.model.User;
import com.icin.banking.model.UserDtls;

@Service
public class UserServiceImpl implements UserService{
  @Autowired
  private UserRepo repository;
  @Autowired
  private UserDetailsRepo dtlsrepo;
  @Override
  public User addUser(User user) {
    return repository.save(user);
  }
  
  @Override
  public UserDtls addUserDetails(UserDtls userDtls) {
    return dtlsrepo.save(userDtls);
  }
  @Override
  public User getUserById(int userId) {
    return repository.findById(userId).get();
  }
  @Override
  public List<User> getAllUsers(){
    return repository.findAll();
  }
  
  @Override
  public void updateUser(int userId, String newpassword) {
    // check if the user with the passed id exists or not
    User user1 = repository.findById(userId).orElseThrow(null);
    user1.setPassword(newpassword);
    // If user exists then updated
    repository.save(user1);
  }
  
  @Override
  public void deleteUserById(int userId) {
    try {
      repository.deleteById(userId);  
    }catch(DataAccessException ex){
      throw new RuntimeException(ex.getMessage());
    }
  }
}