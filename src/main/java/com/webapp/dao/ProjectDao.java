package com.webapp.dao;

import java.util.List;

import com.webapp.dto.ProjectDTO;
import com.webapp.model.Project;


public interface ProjectDao {
    
	//Get all projects in the database
	List<Project> getProjects();
	
	//save a new or updated project
	void saveProject(Project project);
	
	//Get the project with the project id.
	Project getProject(int projectId);
	
	//get projects assigned to user
	List<Project> getProjectWithUserId(int userId);
	
	//get projects using owner
	List<Project> getProjectWithOwnerId(int userId);
	
	
	//get project name using project id
	String getProjectNameWithId(int projectId);

}
