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

import com.webapp.model.Project;
import com.webapp.service.ProjectService;


@Controller
@RequestMapping("/project")
public class ProjectController {

	@Autowired
	private ProjectService projectService;
	

	@GetMapping("/view")
	public String listProjects(Model theModel) {
		List<Project> theProjects = projectService.getProjects();
		
		theModel.addAttribute("projects", theProjects);
		return "list-project";
	}

	@GetMapping("/showForm")
	public String showFormForAdd(Model theModel) {
		Project theProject = new Project();
		theModel.addAttribute("project", theProject);
		return "project-form";
	}

	@PostMapping("/saveProject")
	public String saveProject(@ModelAttribute("project") Project theProject) {
		if(theProject.getEndDate() == "") {
			theProject.setEndDate(null);
			System.out.println("Project ende date is empty")
		}
		System.out.println("End Date"+theProject.getEndDate());
		Date date = new Date();
		theProject.setCreatedBy(1);
		theProject.setCreatedDate(date);
		System.out.println(date);
		projectService.saveProject(theProject);
		return "redirect:/project/view";
	}

	@GetMapping("/updateProjectForm")
	public String showFormForUpdate(@RequestParam("projectId") int theId, Model theModel) {
		Project theProject = projectService.getProject(theId);
		Date date = new Date();
		theProject.setUpdatedDate(date);
		theProject.setUpdatedBy(1);
		System.out.println(date);
		theModel.addAttribute("project", theProject);
		return "project-form";
	}

}
