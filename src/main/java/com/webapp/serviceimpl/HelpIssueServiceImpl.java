package com.webapp.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webapp.constants.CommonConstants;
import com.webapp.dao.HelpIssueDao;
import com.webapp.facade.AuthenticationFacade;
import com.webapp.model.HelpIssue;
import com.webapp.service.HelpIssueService;

@Service
public class HelpIssueServiceImpl implements HelpIssueService{
	
	@Autowired
	private HelpIssueDao helpIssueDao;
	
     //Authentication object 
		@Autowired
		private AuthenticationFacade authenticationFacade;
		
		
		

	@Override
	public List<HelpIssue> getHelpIssues(int moduleId) {
		 return helpIssueDao.getHelpIssues(moduleId);
		
	}

	//Great new help issue
	@Override
	@Transactional
	public void addNewHelpIssue(int moduleId, HelpIssue helpIssue) {
		helpIssue.setCreatedBy(authenticationFacade.getUserIdFromAuth());
		helpIssue.setCreatedDate(CommonConstants.CURRENT_STR_DATE);
		helpIssueDao.addNewHelpIssue(moduleId, helpIssue);		
	}

	@Override
	public HelpIssue getHelpIssue(int helpIssueId) {
		return helpIssueDao.getHelpIssue(helpIssueId);
	}

	

}
