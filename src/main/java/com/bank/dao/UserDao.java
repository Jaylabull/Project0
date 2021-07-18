package com.bank.dao;

import java.sql.SQLException;
import java.util.List;

import com.bank.models.Account;
import com.bank.models.User;

public interface UserDao {
	 List<User> getAllUsers();
	
	 User getUserByUsername(String userName);
	
	 void createUser(User u) throws SQLException;
	
	 void updateUser(User u);
	
	 void deleteUser(User u);

}

