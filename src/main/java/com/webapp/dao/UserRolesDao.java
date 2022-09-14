package com.webapp.dao;

import java.util.List;

import com.webapp.model.UserRoles;

public interface UserRolesDao {

	// Get all user roles in the database for the projects
			public List<UserRoles> getUserRoles();

			// save a new or updated Ticket comment
			public void addNewUserRole(UserRoles userRoles);

			// Get the user role using id.
			public UserRoles getUserRole(int roleId);
}
