package com.webapp.dao;

import java.util.List;

import com.webapp.model.User;

public interface UserDao {
	 List<User> getUsers();
	  void saveUser(User usr);
	  User getUser(int usrId);
	
	  int getUserRoleId(int usrId);
//	public void deleteUser(int usrId);
	
	  List<User> getUsersById(int roleId);

}
