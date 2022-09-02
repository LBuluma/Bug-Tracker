package com.webapp.service;

import java.util.List;

import com.webapp.model.ProjectAssignment;

public interface ProjectAssignmentService {
	
	//Get all projects assignments in the database
			public List<ProjectAssignment> getProjectAssignments();
			
			//save a new or updated project assignment
			public  void assignProject(ProjectAssignment projectAssignment);
			
			//Get the project assignment with the assigner user id.
			public  ProjectAssignment getAssignment(int assigned_id);
}
