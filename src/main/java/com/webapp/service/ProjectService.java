package com.webapp.service;

import java.text.ParseException;
import java.util.List;

import com.webapp.dto.ProjectDTO;
import com.webapp.model.Project;

public interface ProjectService {

	//Get all projects in the database
		public List<ProjectDTO> getProjects();
		
		//save a new 
		  void saveProject(ProjectDTO projectDto) throws ParseException;
		
		//Get the project with the project id.
		  Project getProject(int projectId);

		//update a project
		  void updateProject(ProjectDTO projectDto) throws ParseException;

		ProjectDTO getProjectDto(int projectId);
		
		//Get project with user Id 
		List<Project> getProjectsWithUserId(int userId);
		
		//Get projects using project owner
		List<Project> getProjectsWithOwnerId();
		
		//Get project name with project Id
		String getProjectNameWithId(int projectId);
		
		ProjectDTO convertProjectToDto(Project project);
				
}
