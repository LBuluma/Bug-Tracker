package com.webapp.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webapp.dao.ProjectAssignmentDao;
import com.webapp.model.ProjectAssignment;
import com.webapp.service.ProjectAssignmentService;

@Service
public class ProjectAssignmentServiceImpl implements ProjectAssignmentService{

	@Autowired
	private ProjectAssignmentDao projectAssignmentDao;
	
	@Override
	public List<ProjectAssignment> getProjectAssignments() {
         return projectAssignmentDao.getProjectAssignments();
		
	}

	@Override
	@Transactional
	public void assignProject(ProjectAssignment projectAssignment) {
		projectAssignmentDao.assignProject(projectAssignment);
		
	}

	@Override
	public ProjectAssignment getAssignment(int assigned_id) {
		ProjectAssignment projectAssignment = projectAssignmentDao.getProjectAssignment(assigned_id);
		return projectAssignment;
	}

;
}
