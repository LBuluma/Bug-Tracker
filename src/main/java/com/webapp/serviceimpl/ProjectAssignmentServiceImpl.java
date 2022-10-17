package com.webapp.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webapp.constants.CommonConstants;
import com.webapp.dao.ProjectAssignmentDao;
import com.webapp.facade.AuthenticationFacade;
import com.webapp.model.ProjectAssignment;
import com.webapp.service.ProjectAssignmentService;

@Service
public class ProjectAssignmentServiceImpl implements ProjectAssignmentService{

	@Autowired
	private ProjectAssignmentDao projectAssignmentDao;

//	//Authentication object 
		@Autowired
		private AuthenticationFacade authenticationFacade;
	

	
	@Override
	public List<ProjectAssignment> getProjectAssignments() {
         return projectAssignmentDao.getProjectAssignments();
		
	}

	//Save new project assignment
	@Override
	@Transactional
	public void assignProject(ProjectAssignment projectAssignment) {
		projectAssignment.setAssignmentDate(CommonConstants.CURRENT_STR_DATE);
		projectAssignment.setCreatedDate(CommonConstants.CURRENT_STR_DATE);
    	projectAssignment.setCreatedBy(Integer.parseInt(authenticationFacade.getUserIdFromAuth()));
		projectAssignmentDao.assignProject(projectAssignment);
		
	}

	@Override
	public ProjectAssignment getAssignment(int assigned_id) {
		ProjectAssignment projectAssignment = projectAssignmentDao.getProjectAssignment(assigned_id);
		return projectAssignment;
	}

;
}
