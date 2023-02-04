package com.webapp.dao;

import java.util.List;

import com.webapp.model.UserRoles;

public interface UserRolesDao {

	// Get all user roles in the database for the projects
			 List<UserRoles> getUserRoles();

			// save a new or updated Ticket comment
			 void addNewUserRole(UserRoles userRoles);

			// Get the user role using id.
			 UserRoles getUserRole(int roleId);
			 
			 //get user role name using role id
			 String getUserRoleNameWithId(int roleId);
}
