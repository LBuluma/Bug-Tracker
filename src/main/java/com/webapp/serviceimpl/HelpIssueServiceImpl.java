package com.webapp.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.webapp.dao.HelpIssueDao;
import com.webapp.model.HelpIssue;
import com.webapp.service.HelpIssueService;

public class HelpIssueServiceImpl implements HelpIssueService{
	
	@Autowired
	private HelpIssueDao helpIssueDao;

	@Override
	public List<HelpIssue> getHelpIssues(int moduleId) {
		List<HelpIssue> helpIssueList = helpIssueDao.getHelpIssues(moduleId);
		return helpIssueList;
	}

	@Override
	public void addNewHelpIssue(int moduleId, HelpIssue helpIssue) {
		helpIssueDao.addNewHelpIssue(moduleId, helpIssue);		
	}

	@Override
	public HelpIssue getHelpIssue(int helpIssueId) {
		return helpIssueDao.getHelpIssue(helpIssueId);
	}

	

}
