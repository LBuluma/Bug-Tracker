package com.webapp.serviceimpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webapp.constants.CommonConstants;
import com.webapp.dao.ProjectDao;
import com.webapp.facade.AuthenticationFacade;
import com.webapp.model.Project;
import com.webapp.service.ProjectService;


@Service
public class ProjectServiceImpl implements ProjectService{
	
	//projectdao object is autowired
	@Autowired
	private ProjectDao projectDao;
	
	//Authentication object 
   @Autowired
    private AuthenticationFacade authenticationFacade;


	
	//get all the projects
	@Override
	public List<Project> getProjects() {
		
		return projectDao.getProjects();
	}

	//save a new project
	@Override
	@Transactional
	public void saveProject(Project project) {		
		//Set the created date to the current date
		project.setCreatedDate(CommonConstants.CURRENT_DATE);
//		//set the owner to the current logged in user
	project.setOwner(Integer.parseInt(authenticationFacade.getUserIdFromAuth()));
	//set created by to the current logged in user
	project.setCreatedBy(Integer.parseInt(authenticationFacade.getUserIdFromAuth()));
		//save the project
		projectDao.saveProject(project);
		
	}

	
	//get a specific project using project ID
	@Override
	public Project getProject(int projectId) {
		return projectDao.getProject(projectId);
	
	}

	
}
