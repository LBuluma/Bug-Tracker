package com.webapp.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.webapp.commonfunctions.CommonUserFMethods;
import com.webapp.dto.ProjectAssignmentDto;
import com.webapp.model.Project;
import com.webapp.model.ProjectAssignment;
import com.webapp.model.User;
import com.webapp.model.UserRoles;
import com.webapp.service.ProjectAssignmentService;
import com.webapp.service.ProjectService;
import com.webapp.service.UserRolesService;
import com.webapp.service.UserService;

@Controller
@RequestMapping(value = "/assignment")
public class ProjectAssignmentController {

	@Autowired
	private ProjectAssignmentService projectAssignmentService;
	
	  @Autowired
	    private UserService userService;
	  
	  @Autowired
	    private UserRolesService userRolesService;
	  
	  @Autowired
	    private ProjectService projectService;

	@GetMapping("/view")
	public String listProjectAssignments(@RequestParam("projectId") int theId, Model theModel) {
		List<ProjectAssignmentDto> theProjectAssignmentDto =
				projectAssignmentService.getProjectAssignmentDto(theId);
		theModel.addAttribute("theProjectAssignmentDto", theProjectAssignmentDto);
		return "list-assignment";
	}
	
	@GetMapping("/viewProjectAssignment")
	public String listAssignments(Model theModel) {
		List <Project> projectList = projectService.getProjectsWithOwnerId();
		theModel.addAttribute("projects", projectList);
		return "list-project-assignment";
	}

	@GetMapping("/showForm")
	public String showFormForAdd(Model theModel) {
		List <User> userList = userService.getUsers();
		List <UserRoles> rolesList = userRolesService.getUserRoles();
		ProjectAssignmentDto theProjectAssignmentDto = new ProjectAssignmentDto();
		List <Project> projectList = projectService.getProjectsWithOwnerId();
		theModel.addAttribute("projectAssignment", theProjectAssignmentDto);
		theModel.addAttribute("users", userList);
		theModel.addAttribute("roles", rolesList);
		theModel.addAttribute("projects", projectList);
		return "project-assignment-form";
	}

	@PostMapping("/saveAssignment")
	public String saveProjectAssignments(@ModelAttribute("projectAssignment") ProjectAssignmentDto projectAssignmentDto) {
		
     	projectAssignmentService.assignProject(projectAssignmentDto);
		return "redirect:/assignment/showForm";
	}

	@GetMapping("/updateAssignmentForm")
	public String showFormForUpdate(@RequestParam("assignmentId") int theId, Model theModel) {
		ProjectAssignmentDto theProjectAssignmentDto = projectAssignmentService.getAssignmentDto(projectAssignmentService.getAssignment(theId));
		theModel.addAttribute("projectAssignment", theProjectAssignmentDto);
		return "update-assignment";
	}
	
	@PostMapping("/updateAssignment")
	public String updateProjectAssignment(@ModelAttribute("projectAssignment") ProjectAssignmentDto theProjectAssignmentDto) {
		
     	projectAssignmentService.updateAssignment(theProjectAssignmentDto);
		return "redirect:/assignment/viewProjectAssignment";
	}

}
