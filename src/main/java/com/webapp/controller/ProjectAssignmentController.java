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
import com.webapp.model.ProjectAssignment;
import com.webapp.service.ProjectAssignmentService;

@Controller
@RequestMapping(value = "/assignment")
public class ProjectAssignmentController {

	@Autowired
	private ProjectAssignmentService projectAssignmentService;

	@GetMapping("/view")
	public String listProjects(Model theModel) {
		List<ProjectAssignment> theProjectAssignment = projectAssignmentService.getProjectAssignments();
		theModel.addAttribute("projectAssignment", theProjectAssignment);
		return "list-assignment";
	}

	@GetMapping("/showForm")
	public String showFormForAdd(Model theModel) {
		ProjectAssignment theProjectAssignment = new ProjectAssignment();
		theModel.addAttribute("projectAssignment", theProjectAssignment);
		return "project-assignment-form";
	}

	@PostMapping("/saveAssignment")
	public String saveProject(@ModelAttribute("projectAssignment") ProjectAssignment theProjectAssignment) {
		System.out.println("End Date" + theProjectAssignment.getAssignedId());
		Date date = new Date();
		theProjectAssignment.setCreatedBy(1);
		theProjectAssignment.setCreatedDate(date);
		theProjectAssignment.setAssignedId(1);
		theProjectAssignment.setAssignmentDate(date);
		System.out.println(date);
		projectAssignmentService.assignProject(theProjectAssignment);
		return "redirect:/assignment/view";
	}

	@GetMapping("/updateAssignmentForm")
	public String showFormForUpdate(@RequestParam("assignmentId") int theId, Model theModel) {
		ProjectAssignment theProjectAssignment = projectAssignmentService.getAssignment(theId);
		Date date = new Date();
		theProjectAssignment.setUpdatedDate(date);
		theProjectAssignment.setUpdatedBy(1);
		System.out.println(date);
		theModel.addAttribute("projectAssignment", theProjectAssignment);
		return "project-assignment-form";
	}

}
