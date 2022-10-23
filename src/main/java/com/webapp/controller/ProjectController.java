package com.webapp.controller;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.webapp.dto.ProjectDTO;
import com.webapp.model.Project;
import com.webapp.service.ProjectService;


@Controller
@RequestMapping("/project")
public class ProjectController {

	@Autowired
	private ProjectService projectService;
	
//List all the projects contained in the application
	@GetMapping("/view")
	public String listProjects(Model theModel) {
		//Retrieve projects and store them in a list
		List<Project> theProjects = projectService.getProjects();
		
		theModel.addAttribute("projects", theProjects);
		return "list-project";
	}

	//Display the form for adding a new project
	@GetMapping("/showForm")
	public String showFormForAdd(Model theModel) {
		//Create empty object
		Project theProject = new Project();
		theModel.addAttribute("project", theProject);
		return "project-form";
	}

	//save a new project
	@PostMapping("/saveProject")
	public String saveProject(@ModelAttribute("project") ProjectDTO projectDto) throws ParseException {
		projectService.saveProject(projectDto);
		return "redirect:/project/view";
	}

	@GetMapping("/updateProjectForm")
	public String showFormForUpdate(@RequestParam("projectId") int theId, Model theModel) {
		ProjectDTO projectDto = projectService.getProjectDto(theId);
		System.out.println("showFormForUpdate:" +projectDto.getOwnerName());
		theModel.addAttribute("project", projectDto);
		return "update-project";
	}
	
	//save a new project
		@PostMapping("/updateProject")
		public String updateProject(@ModelAttribute("project") ProjectDTO projectDto) throws ParseException {
			System.out.println("updateProject:IN");
			projectService.updateProject(projectDto);
			return "redirect:/project/view";
		}

}
