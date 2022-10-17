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

import com.webapp.model.HelpIssue;
import com.webapp.service.HelpIssueService;

@Controller
@RequestMapping(value = "/helpissue")
public class HelpIssueController {
	
	@Autowired
	private HelpIssueService helpIssueService;
	
	
	//Get all the help issues using module Id
	@GetMapping("/view")
	public String listHelpIssues(@RequestParam("moduleId") int moduleId,Model theModel) {
		List<HelpIssue> helpIssueList = helpIssueService.getHelpIssues(moduleId);
		theModel.addAttribute("helpIssues", helpIssueList);
		return "list-helpIssues";
	}

	//Display the form for adding new help issue
	@GetMapping("/showForm")
	public String showFormForAdd(Model theModel) {
		HelpIssue thehelpIssue = new HelpIssue();
		theModel.addAttribute("helpIssue", thehelpIssue);
		return "project-helpissue-form";
	}

	@PostMapping("/saveHelpIssue")
	public String saveHelpIssue(@ModelAttribute("helpIssue") HelpIssue thehelpIssue) {
		return "redirect:/helpissue/view";
	}

	@GetMapping("/updateHelpIssueForm")
	public String showFormForUpdate(@RequestParam("helpIssueId") int theId, Model theModel) {
		HelpIssue thehelpIssue = helpIssueService.getHelpIssue(theId);
		theModel.addAttribute("helpIssue", thehelpIssue);
		return "project-helpIssue-form";
	}
	
	

	

}
