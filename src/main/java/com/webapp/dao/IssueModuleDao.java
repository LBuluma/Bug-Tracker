package com.webapp.dao;

import java.util.List;

import com.webapp.model.IssueModule;

public interface IssueModuleDao {
	//Get all IssueModule in the database
			public List<IssueModule> getIssueModules(int projectId);
			
			//save a new or updated IssueModule
			public  void addNewIssueModule(int projectId, IssueModule issueModule);
			
			//Get the IssueModuleusing id.
			public  IssueModule getIssueModule(int moduleId);

}
