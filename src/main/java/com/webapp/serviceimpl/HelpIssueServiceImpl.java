package com.webapp.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webapp.dao.HelpIssueDao;
import com.webapp.model.HelpIssue;
import com.webapp.service.HelpIssueService;

@Service
public class HelpIssueServiceImpl implements HelpIssueService{
	
	@Autowired
	private HelpIssueDao helpIssueDao;

	@Override
	public List<HelpIssue> getHelpIssues(int moduleId) {
		List<HelpIssue> helpIssueList = helpIssueDao.getHelpIssues(moduleId);
		return helpIssueList;
	}

	@Override
	@Transactional
	public void addNewHelpIssue(int moduleId, HelpIssue helpIssue) {
		helpIssueDao.addNewHelpIssue(moduleId, helpIssue);		
	}

	@Override
	public HelpIssue getHelpIssue(int helpIssueId) {
		return helpIssueDao.getHelpIssue(helpIssueId);
	}

	

}
