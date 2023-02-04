package com.webapp.serviceimpl;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webapp.commonfunctions.CommonUserFMethods;
import com.webapp.constants.CommonConstants;
import com.webapp.dao.ProjectDao;
import com.webapp.dto.ProjectDTO;
import com.webapp.facade.AuthenticationFacade;
import com.webapp.model.Project;
import com.webapp.service.ProjectService;
import com.webapp.service.UserService;

@Service
public class ProjectServiceImpl implements ProjectService {

	// projectdao object is autowired
	@Autowired
	private ProjectDao projectDao;

	// Authentication object
	@Autowired
	private AuthenticationFacade authenticationFacade;
	
	
	@Autowired
	private UserService userService;
	
	
	Project project =null;

	private ProjectDTO projectDTO;

	// get all the projects
	@Override
	public List<ProjectDTO> getProjects() {
		
		List <ProjectDTO> projectDtoList = new ArrayList<>();
		List <Project > projectList = projectDao.getProjects();
		for ( Project projectVar :  projectList) {
			ProjectDTO projectDto = convertProjectToDto(projectVar);
			projectDto.setOwnerName(userService.getUserFullName(projectVar.getOwner()));
			projectDtoList.add(projectDto);
			
		}
		

		 return projectDtoList;
	}

	// save a new project
	@Override
	@Transactional
	public void saveProject(ProjectDTO projectDto) {
		
		project = new Project();			
		project.setStartDate(projectDto.getStartDate());	
		project.setDescription(projectDto.getDescription());
		
		if(projectDto.getEndDate().length() > 0) {
		project.setEndDate(projectDto.getEndDate());
		}
		project.setOwner(projectDto.getOwnerId());
		project.setProjectName(projectDto.getProjectName());
		// Set the created date to the current date
		project.setCreatedDate(CommonConstants.CURRENT_DATE);
		System.out.println("CommonConstants.CURRENT_DATE:"+ CommonConstants.CURRENT_DATE);
//		//set the owner to the current logged in user
		project.setOwner(Integer.parseInt(authenticationFacade.getUserIdFromAuth()));
		// set created by to the current logged in user
		project.setCreatedBy(Integer.parseInt(authenticationFacade.getUserIdFromAuth()));
		// save the project
		projectDao.saveProject(project);

	}

	// Update an existing project
	@Override
	@Transactional
	public void updateProject(ProjectDTO projectDto) {
		project = new Project();			
		project.setStartDate(projectDto.getStartDate());	
		project.setDescription(projectDto.getDescription());
		
		if(projectDto.getEndDate().length() > 0) {
		project.setEndDate(projectDto.getEndDate());
		}
		project.setOwner(projectDto.getOwnerId());
		project.setProjectName(projectDto.getProjectName());
		// Set the created date to the current date
		try {
			project.setCreatedDate(CommonUserFMethods.convertToDate(projectDto.getCreatedDate()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		project.setProjectId(projectDto.getProjectId());
		project.setCreatedBy(projectDto.getCreatedBy());
		
		System.out.println("updateProject:createdDate " + projectDto.getCreatedDate() );
		// Set the updated date to the current date
		projectDto.setUpdatedDate(CommonConstants.CURRENT_STR_DATE);
		// set updated by to the current logged in user
		projectDto.setUpdatedBy(authenticationFacade.getUserIdFromAuth());
		// save the project
		projectDao.saveProject(project);

	}

	// get a specific project using project ID
	@Override
	public Project getProject(int projectId) {
		return projectDao.getProject(projectId);

	}
	
	
	@Override
	public ProjectDTO getProjectDto(int projectId) {
		return convertProjectToDto(getProject(projectId));

	}

	@Override
	public List<Project> getProjectsWithUserId(int userId) {
		
		return null;
	}

	@Override
	public List<Project> getProjectsWithOwnerId() {
		int projectService = Integer.parseInt(authenticationFacade.getUserIdFromAuth());
		return projectDao.getProjectWithOwnerId(projectService);
		
	}

	@Override
	public String getProjectNameWithId(int projectId) {
		return projectDao.getProjectNameWithId(projectId);
	}
	
	@Override
	public ProjectDTO convertProjectToDto(Project project) {
		projectDTO = new ProjectDTO();
		projectDTO.setCreatedBy(project.getCreatedBy());
		projectDTO.setCreatedDate(CommonUserFMethods.convertDateToString(project.getCreatedDate()));
		projectDTO.setDescription(project.getDescription());
		projectDTO.setEndDate(project.getEndDate());
		projectDTO.setOwnerId(project.getOwner());
		projectDTO.setProjectId(project.getProjectId());
		projectDTO.setProjectName(project.getProjectName());
		projectDTO.setStartDate(project.getStartDate());
		projectDTO.setUpdatedBy(project.getUpdatedBy());
		if(project.getUpdatedDate()!= null) {
		projectDTO.setUpdatedDate(CommonUserFMethods.convertDateToString(project.getUpdatedDate()));
		}
		projectDTO.setOwnerName(userService.getUserFullName(project.getOwner()));
		return projectDTO;

	}




}
