package com.webapp.service;

import java.util.List;

import com.webapp.model.User;


public interface UserService {

	public List<User> getUsers();
	public  void saveUser(User usr);
	public  User getUser(int usrId);
	public List<Object> getUserDetails(int usrId);
	
}
