package com.webapp.serviceimpl;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webapp.commonfunctions.CommonUserFMethods;
import com.webapp.constants.CommonConstants;
import com.webapp.dao.ProjectAssignmentDao;
import com.webapp.dto.ProjectAssignmentDto;
import com.webapp.facade.AuthenticationFacade;
import com.webapp.model.ProjectAssignment;
import com.webapp.service.ProjectAssignmentService;
import com.webapp.service.ProjectService;
import com.webapp.service.UserRolesService;
import com.webapp.service.UserService;




@Service
public class ProjectAssignmentServiceImpl implements ProjectAssignmentService{

	@Autowired
	private ProjectAssignmentDao projectAssignmentDao;

//	//Authentication object 
		@Autowired
		private AuthenticationFacade authenticationFacade;
		
		
		@Autowired
		private UserRolesService userRolesService;

		@Autowired
		private ProjectService projectService;

		@Autowired
		private UserService userService;
	

	
	@Override
	public List<ProjectAssignment> getProjectAssignments() {
		
         return projectAssignmentDao.getProjectAssignments();
		
	}

	//Save new project assignment
	@Override
	@Transactional
	public void assignProject(ProjectAssignmentDto projectAssignmentDto) {
		ProjectAssignment projectAssignment  = new ProjectAssignment();
		projectAssignment.setAssignedId(Integer.parseInt(projectAssignmentDto.getAssignedId()));
		projectAssignment.setProjectId(Integer.parseInt(projectAssignmentDto.getProjectId()));
		projectAssignment.setComments(projectAssignmentDto.getComments());
		projectAssignment.setAssignmentDate(CommonConstants.CURRENT_DATE);
		projectAssignment.setCreatedDate(CommonConstants.CURRENT_DATE);
		projectAssignment.setFlag(CommonConstants.ACTIVE_FLAG);
    	projectAssignment.setCreatedBy(Integer.parseInt(authenticationFacade.getUserIdFromAuth()));
		projectAssignmentDao.assignProject(projectAssignment);
		
	}

	@Override
	public ProjectAssignment getAssignment(int assignedId) {
		return projectAssignmentDao.getProjectAssignment(assignedId);
		 
	}
	
	
	
	public ProjectAssignmentDto getAssignmentDto(ProjectAssignment projectAssignment) {
		ProjectAssignmentDto projectAssignmentDto = new ProjectAssignmentDto();
		projectAssignmentDto.setAssignedId(CommonUserFMethods.convertIntToString(projectAssignment.getAssignedId()));
		projectAssignmentDto.setAssignedName(userService.getUserFullName(projectAssignment.getAssignedId()));
		projectAssignmentDto.setAssignmentId(CommonUserFMethods.convertIntToString(projectAssignment.getAssignmentId()));
		projectAssignmentDto.setProjectId(CommonUserFMethods.convertIntToString(projectAssignment.getProjectId()) );
		projectAssignmentDto.setProjectName(projectService.getProjectNameWithId(projectAssignment.getProjectId()));
		projectAssignmentDto.setRoleName(userRolesService.getUserRoleNameWithId(userService.getUserRoleId(projectAssignment.getAssignedId())));
		projectAssignmentDto.setCreatedBy(CommonUserFMethods.convertIntToString(projectAssignment.getCreatedBy()));
		projectAssignmentDto.setCreatedDate(CommonUserFMethods.convertDateToString(projectAssignment.getCreatedDate()));
		projectAssignmentDto.setAssignmentDate(CommonUserFMethods.convertDateToString(projectAssignment.getAssignmentDate()));
		
		return projectAssignmentDto;
		
	}

	@Override
	public List<ProjectAssignmentDto> getProjectAssignmentDto(int projectId) {
		List <ProjectAssignment> projectAssignmentList = getProjectAssignmentWithProjectId(projectId);
		List <ProjectAssignmentDto> projectAssignmentDtoList = new ArrayList<>();
		for (ProjectAssignment projectAssignment: projectAssignmentList) {
			ProjectAssignmentDto projectAssignmentDto = new ProjectAssignmentDto();
			projectAssignmentDto.setAssignedName(userService.getUserFullName(projectAssignment.getAssignedId()));
			projectAssignmentDto.setAssignmentDate(CommonUserFMethods.convertDateToString(projectAssignment.getAssignmentDate()));
			projectAssignmentDto.setComments(projectAssignment.getComments());
			projectAssignmentDto.setProjectName(projectService.getProjectNameWithId(projectAssignment.getProjectId()));
			projectAssignmentDto.setRoleName(userRolesService.getUserRoleNameWithId(userService.getUserRoleId(projectAssignment.getAssignedId())));
			projectAssignmentDto.setAssignmentId(CommonUserFMethods.convertIntToString(projectAssignment.getAssignmentId()));
			projectAssignmentDtoList.add(projectAssignmentDto);
		}
		
		return projectAssignmentDtoList;
	}

	@Override
	public List<ProjectAssignment> getProjectAssignmentWithProjectId(int projectId) {
		
		return projectAssignmentDao.getProjectAssignmentWithProjectId(projectId) ;
	}

	@Override
	@Transactional
	public void updateAssignment(ProjectAssignmentDto projectAssignmentDto ) {	
			ProjectAssignment projectAssignment  = new ProjectAssignment();
			projectAssignment.setAssignmentId(CommonUserFMethods.convertStringToInt(projectAssignmentDto.getAssignmentId() ));
			projectAssignment.setAssignedId(Integer.parseInt(projectAssignmentDto.getAssignedId()));
			projectAssignment.setProjectId(Integer.parseInt(projectAssignmentDto.getProjectId()));
			projectAssignment.setComments(projectAssignmentDto.getComments());
			try {
				projectAssignment.setCreatedDate(CommonUserFMethods.convertToDate(projectAssignmentDto.getCreatedDate() ));
				projectAssignment.setAssignmentDate(CommonUserFMethods.convertToDate(projectAssignmentDto.getAssignmentDate()) );
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			projectAssignment.setUpdatedDate(CommonConstants.CURRENT_DATE);
			projectAssignment.setFlag(CommonConstants.INACTIVE_FLAG);
	    	projectAssignment.setCreatedBy(CommonUserFMethods.convertStringToInt(projectAssignmentDto.getCreatedBy()));
	    	projectAssignment.setUpdatedBy(Integer.parseInt(authenticationFacade.getUserIdFromAuth()));
			projectAssignmentDao.assignProject(projectAssignment);
			
		}
	}
	
	


