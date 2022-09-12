package com.webapp.service;

import java.util.List;

import com.webapp.model.IssueCategory;

public interface IssueCategoryService {
	//Get all IssueCategory in the database
	public List<IssueCategory> getIssueCategories(int projectId);
	
	//save a new or updated IssueCategory
	public  void addNewIssueCategory(int projectId,IssueCategory issueCategory);
	
	//Get the Issue Category using id.
	public  IssueCategory getIssueCategory(int categoryId);
}
