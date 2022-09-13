package com.webapp.service;

import java.util.List;

import com.webapp.model.HelpIssue;


public interface HelpIssueService {

	//Get all help issues in the database for the module
		public List<HelpIssue> getHelpIssues(int moduleId);
		
		//save a new or updated help issue
		public  void addNewHelpIssue(int moduleId, HelpIssue helpIssue);
		
		//Get the help Issue using id.
		public  HelpIssue getHelpIssue(int helpIssueId);
}
