package com.webapp.dao;

import com.webapp.model.ApplicationUser;


//Application user DAO
public interface ApplicationUserDao {
	
//persist the application user.
public  void saveAppUsr(ApplicationUser appUsr);


//Get user id from application user details table using user name
public String getUserIdByName(String email);
}
