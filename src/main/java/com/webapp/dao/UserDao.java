package com.webapp.dao;

import java.util.List;

import com.webapp.model.User;

public interface UserDao {
	public List<User> getUsers();
	public  void saveUser(User usr);
	public  User getUser(int usrId);
//	public void deleteUser(int usrId);
	

}
