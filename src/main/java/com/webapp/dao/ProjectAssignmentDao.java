package com.webapp.dao;

import java.util.List;

import com.webapp.model.ProjectAssignment;

public interface ProjectAssignmentDao {

	//Get all projects assignments in the database
		public List<ProjectAssignment> getProjectAssignments();
		
		//save a new or updated project
		public  void assignProject(ProjectAssignment projectAssignment);
		
		//Get the project assignments with the assigned id.
		public  ProjectAssignment getProjectAssignment(int assignedId);

		

}
