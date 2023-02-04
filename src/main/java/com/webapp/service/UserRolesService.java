package com.webapp.service;

import java.util.List;

import com.webapp.model.UserRoles;

public interface UserRolesService {
	
	
	// Get all user roles in the database for the projects
		 List<UserRoles> getUserRoles();

		// save a new or updated user role
		 void addNewUserRole(UserRoles userRoles);

		// Get the user role using id.
		 UserRoles getUserRole(int roleId);
		
		//get user role name with role Id
		String getUserRoleNameWithId(int roleId);

}
