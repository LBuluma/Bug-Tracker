package com.webapp.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webapp.constants.CommonConstants;
import com.webapp.dao.IssueCategoryDao;
import com.webapp.facade.AuthenticationFacade;
import com.webapp.model.IssueCategory;
import com.webapp.service.IssueCategoryService;

@Service
public class IssueCategoryServiceImpl implements IssueCategoryService {
	@Autowired
	private IssueCategoryDao issueCategoryDao;

//	// Authentication object
	@Autowired
	private AuthenticationFacade authenticationFacade;



	@Override
	public List<IssueCategory> getIssueCategories(int projectId) {
		return issueCategoryDao.getIssueCategories(projectId);
	}

	
	//save the new category created
	@Override
	@Transactional
	public void addNewIssueCategory(int projectId, IssueCategory issueCategory) {
		//set the created by to logged in user
		issueCategory.setCreatedBy(Integer.parseInt(authenticationFacade.getUserIdFromAuth()));
		//set the created date using the current date
		issueCategory.setCreatedDate(CommonConstants.CURRENT_STR_DATE);
		issueCategoryDao.addCategory(projectId, issueCategory);

	}

	@Override
	public IssueCategory getIssueCategory(int categoryId) {
		return issueCategoryDao.getIssueCategory(categoryId);
	}

}
