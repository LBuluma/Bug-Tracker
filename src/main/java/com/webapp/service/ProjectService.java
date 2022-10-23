package com.webapp.service;

import java.text.ParseException;
import java.util.List;

import com.webapp.dto.ProjectDTO;
import com.webapp.model.Project;

public interface ProjectService {

	//Get all projects in the database
		public List<Project> getProjects();
		
		//save a new 
		public  void saveProject(ProjectDTO projectDto) throws ParseException;
		
		//Get the project with the project id.
		public  Project getProject(int projectId);

		//update a project
		public  void updateProject(ProjectDTO projectDto) throws ParseException;

		ProjectDTO getProjectDto(int projectId);
				
}
