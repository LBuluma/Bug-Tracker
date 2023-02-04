package com.webapp.service;

import java.util.List;

import com.webapp.dto.UserDTO;
import com.webapp.model.User;


public interface UserService {

	 List<User> getUsers();
	  void saveUser(UserDTO userDto);
	  UserDTO getUser(int usrId);
     List<Object> getUserDetails(int usrId);
	void updateUser(UserDTO userDto);
	String getUserFullName(int userId);
	int getUserRoleId(int userId);
	List<User> getUsersByRoleId(int roleId);
}
