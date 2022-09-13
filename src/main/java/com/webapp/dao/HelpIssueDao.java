package com.webapp.dao;

import java.util.List;

import com.webapp.model.HelpIssue;

public interface HelpIssueDao {
	//Get all help issues in the database for the module
			public List<HelpIssue> getHelpIssues(int moduleId);
			
			//save a new or updated help issue
			public  void addNewHelpIssue(int moduleId, HelpIssue helpIssue);
			
			//Get the help Issue using id.
			public  HelpIssue getHelpIssue(int helpIssueId);

}
