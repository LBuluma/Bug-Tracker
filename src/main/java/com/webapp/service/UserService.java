package com.webapp.service;

import java.util.List;

import com.webapp.dto.UserDTO;
import com.webapp.model.User;


public interface UserService {

	public List<User> getUsers();
	public  void saveUser(UserDTO userDto);
	public  UserDTO getUser(int usrId);
	public List<Object> getUserDetails(int usrId);
	void updateUser(UserDTO userDto);
	String getUserFullName(int userId);
}
