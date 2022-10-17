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

import com.webapp.model.IssueModule;
import com.webapp.service.IssueModuleService;

@Controller
@RequestMapping("/module")
public class IssueModuleController {
   
	@Autowired
	private IssueModuleService issueModuleService;
	
	@GetMapping("/view")
	public String listModules(@ModelAttribute("projectId") int theId,Model theModel) {
		List<IssueModule> theIssueModule = issueModuleService.getIssueModules(theId);
		theModel.addAttribute("issueModule", theIssueModule);
		return "list-modules";
	}

	@GetMapping("/showForm")
	public String showFormForAdd(Model theModel) {
		IssueModule theIssueModule = new IssueModule();
		theModel.addAttribute("issueModule", theIssueModule);
		return "project-module-form";
	}

	@PostMapping("/saveModule")
	public String saveModule(@RequestParam("projectId") int theId,@ModelAttribute("issueModule") IssueModule theIssueModule) {
		issueModuleService.addNewIssueModule(theId, theIssueModule);
		return "redirect:/module/view";
	}

	@GetMapping("/updateModuleForm")
	public String showFormForUpdate(@RequestParam("projectId") int theId, Model theModel) {
		IssueModule theIssueModule = issueModuleService.getIssueModule(theId);
		theModel.addAttribute("issueModule", theIssueModule);
		return "project-module-form";
	}

	
	

}
