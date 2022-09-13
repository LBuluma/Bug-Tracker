package com.webapp.dao;

import java.util.List;

import com.webapp.model.UserRoles;

public interface UserRolesDao {

	// Get all user roles in the database for the projects
			public List<UserRoles> getUserRoles(int projectId);

			// save a new or updated Ticket comment
			public void addNewUserRole(int projectId,UserRoles userRoles);

			// Get the user role using id.
			public UserRoles getUserRole(int roleId);
}
