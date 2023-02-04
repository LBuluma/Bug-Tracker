package com.webapp.service;

import java.util.List;

import com.webapp.dto.ProjectAssignmentDto;
import com.webapp.model.ProjectAssignment;

public interface ProjectAssignmentService {
	
	//Get all projects assignments in the database
			 List<ProjectAssignment> getProjectAssignments();
			
			//save a new or updated project assignment
			  void assignProject(ProjectAssignmentDto projectAssignmentDto);
			
			//Get the project assignment with the assigner user id.
			  ProjectAssignment getAssignment(int assignedId);
			
			  List<ProjectAssignmentDto> getProjectAssignmentDto(int projectId);
			  
			  List<ProjectAssignment> getProjectAssignmentWithProjectId(int projectId);
			  
			  ProjectAssignmentDto getAssignmentDto(ProjectAssignment projectAssignment);
			  
			  void updateAssignment(ProjectAssignmentDto projectAssignmentDto );
			  
			 
}
