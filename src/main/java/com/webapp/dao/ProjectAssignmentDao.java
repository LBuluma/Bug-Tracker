package com.webapp.dao;

import java.util.List;

import com.webapp.dto.ProjectAssignmentDto;
import com.webapp.model.ProjectAssignment;

public interface ProjectAssignmentDao {

	//Get all projects assignments in the database
		List<ProjectAssignment> getProjectAssignments();
		
		//save a new or updated project
		 void assignProject(ProjectAssignment projectAssignment);
		
		//Get the project assignments with the assigned id.
		ProjectAssignment getProjectAssignment(int assignedId);
		
		//Get the project assignments with the project id.  
		List<ProjectAssignment> getProjectAssignmentWithProjectId(int projectId);

		
}
