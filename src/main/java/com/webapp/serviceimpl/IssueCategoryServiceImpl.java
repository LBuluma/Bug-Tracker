package com.webapp.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webapp.dao.IssueCategoryDao;
import com.webapp.model.IssueCategory;
import com.webapp.service.IssueCategoryService;

@Service
public class IssueCategoryServiceImpl implements IssueCategoryService {
	@Autowired
	private IssueCategoryDao issueCategoryDao;

	@Override
	public List<IssueCategory> getIssueCategories(int projectId) {
		return issueCategoryDao.getIssueCategories(projectId);
	}

	@Override
	public void addNewIssueCategory(int projectId, IssueCategory issueCategory) {
		issueCategoryDao.addCategory(projectId, issueCategory);
		
	}

	@Override
	public IssueCategory getIssueCategory(int categoryId) {
		return issueCategoryDao.getIssueCategory(categoryId);
	}

	

}
