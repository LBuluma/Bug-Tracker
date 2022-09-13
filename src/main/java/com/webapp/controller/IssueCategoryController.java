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

import com.webapp.model.IssueCategory;
import com.webapp.service.IssueCategoryService;

@Controller
@RequestMapping(value = "/category")
public class IssueCategoryController {
	
	@Autowired
	private IssueCategoryService issueCategoryService;
	
	@GetMapping("/view")
	public String listIssueCategories(@ModelAttribute("projectId") int projectId,Model theModel) {
		List<IssueCategory> theIssueCategoryService = issueCategoryService.getIssueCategories(projectId);
		theModel.addAttribute("issueCategoryService", theIssueCategoryService);
		return "list-issueCategory";
	}

	@GetMapping("/showForm")
	public String showFormForAdd(Model theModel) {
		IssueCategory theIssueCategory = new IssueCategory();
		theModel.addAttribute("issueCategory", theIssueCategory);
		return "project-issueCategory-form";
	}

	@PostMapping("/saveIssueCategory")
	public String saveIssueCategory(@RequestParam("categoryId") int theId,@ModelAttribute("issueCategory") IssueCategory theIssueCategory) {
		Date date = new Date();
		theIssueCategory.setCreatedBy(1);
		theIssueCategory.setCreatedDate(date);
		System.out.println(date);
		issueCategoryService.addNewIssueCategory(theId, theIssueCategory);
		return "redirect:/category/view";
	}

	@GetMapping("/updateCategoryForm")
	public String showFormForUpdate(@RequestParam("categoryId") int theId, Model theModel) {
		IssueCategory theIssueCategory = issueCategoryService.getIssueCategory(theId);
		Date date = new Date();
		theIssueCategory.setUpdatedDate(date);
		theIssueCategory.setUpdatedBy(1);
		System.out.println(date);
		theModel.addAttribute("issueCategory", theIssueCategory);
		return "project-issueCategory-form";
	}




}
