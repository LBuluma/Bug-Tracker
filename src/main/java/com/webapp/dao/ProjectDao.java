package com.webapp.dao;

import java.util.List;

import com.webapp.model.Project;


public interface ProjectDao {
    
	//Get all projects in the database
	public List<Project> getProjects();
	
	//save a new or updated project
	public  void saveProject(Project project);
	
	//Get the project with the project id.
	public  Project getProject(int projectId);

}
