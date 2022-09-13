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
	
	@GetMapping("/view")
	public String listHelpIssues(@RequestParam("moduleId") int moduleId,Model theModel) {
		List<HelpIssue> helpIssueList = helpIssueService.getHelpIssues(moduleId);
		theModel.addAttribute("helpIssues", helpIssueList);
		return "list-helpIssues";
	}

	@GetMapping("/showForm")
	public String showFormForAdd(Model theModel) {
		HelpIssue thehelpIssue = new HelpIssue();
		theModel.addAttribute("helpIssue", thehelpIssue);
		return "project-helpissue-form";
	}

	@PostMapping("/saveHelpIssue")
	public String saveHelpIssue(@ModelAttribute("helpIssue") HelpIssue thehelpIssue) {
		Date date = new Date();
		thehelpIssue.setCreatedDate(date);
		return "redirect:/helpissue/view";
	}

	@GetMapping("/updateHelpIssueForm")
	public String showFormForUpdate(@RequestParam("helpIssueId") int theId, Model theModel) {
		HelpIssue thehelpIssue = helpIssueService.getHelpIssue(theId);
		Date date = new Date();
		thehelpIssue.setUpdatedDate(date);
		System.out.println(date);
		theModel.addAttribute("helpIssue", thehelpIssue);
		return "project-helpIssue-form";
	}
	
	

	

}
