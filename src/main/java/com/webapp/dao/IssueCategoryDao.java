package com.webapp.dao;

import java.util.List;

import com.webapp.model.IssueCategory;

public interface IssueCategoryDao {

	//Get all Category in the database
	public List<IssueCategory> getIssueCategories(int projectId);
	
	//save a new or updated Category
	public  void addCategory(int projectId, IssueCategory issueCategory);
	
	//Get the Category with the Category id.
	public  IssueCategory getIssueCategory(int categoryId);
}
