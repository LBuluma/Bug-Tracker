package com.webapp.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webapp.constants.CommonConstants;
import com.webapp.dao.IssueModuleDao;
import com.webapp.facade.AuthenticationFacade;
import com.webapp.model.IssueModule;
import com.webapp.service.IssueModuleService;

@Service
public class IssueModuleServiceImpl implements IssueModuleService{
	
	@Autowired
	private IssueModuleDao isssueModuleDao;
	
	//Authentication object 
		@Autowired
		private AuthenticationFacade authenticationFacade;
		
//		
//		//get current logged in user ID
//		int userId = Integer.parseInt(authenticationFacade.getUserIdFromAuth());

	@Override
	public List<IssueModule> getIssueModules(int projectId) {
		return isssueModuleDao.getIssueModules(projectId);
		
	}

	
	//save the new issue module
	@Override
	@Transactional
	public void addNewIssueModule(int projectId, IssueModule issueModule) {
     	issueModule.setCreatedBy(Integer.parseInt(authenticationFacade.getUserIdFromAuth()));
		issueModule.setCreatedDate(CommonConstants.CURRENT_STR_DATE);
		isssueModuleDao.addNewIssueModule(projectId, issueModule);		
	}

	@Override
	public IssueModule getIssueModule(int moduleId) {
		return isssueModuleDao.getIssueModule(moduleId);
	}

}
