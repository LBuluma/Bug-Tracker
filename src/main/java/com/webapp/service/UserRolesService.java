package com.webapp.service;

import java.util.List;

import com.webapp.model.UserRoles;

public interface UserRolesService {
	
	
	// Get all user roles in the database for the projects
		public List<UserRoles> getUserRoles();

		// save a new or updated user role
		public void addNewUserRole(UserRoles userRoles);

		// Get the user role using id.
		public UserRoles getUserRole(int roleId);

}
