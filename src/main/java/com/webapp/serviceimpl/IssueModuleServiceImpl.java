package com.webapp.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webapp.dao.IssueModuleDao;
import com.webapp.model.IssueModule;
import com.webapp.service.IssueModuleService;

@Service
public class IssueModuleServiceImpl implements IssueModuleService{
	
	@Autowired
	private IssueModuleDao isssueModuleDao;

	@Override
	public List<IssueModule> getIssueModules(int projectId) {
		return isssueModuleDao.getIssueModules(projectId);
		
	}

	@Override
	@Transactional
	public void addNewIssueModule(int projectId, IssueModule issueModule) {
		isssueModuleDao.addNewIssueModule(projectId, issueModule);		
	}

	@Override
	public IssueModule getIssueModule(int moduleId) {
		return isssueModuleDao.getIssueModule(moduleId);
	}

}
