package com.webapp.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.webapp.dao.IssueCategoryDao;
import com.webapp.model.IssueCategory;

public class IssueCategoryDaoImpl implements IssueCategoryDao {

	@Autowired
	private SessionFactory sessionFactory;

	
	@SuppressWarnings("unchecked")
	
	@Override
	public List<IssueCategory> getIssueCategories(int projectId) {
		Session session = this.sessionFactory.openSession();
		List<IssueCategory> issueCategoryList = session.createQuery("from IssueCategory where projectId := projectId").
				setParameter("projectId", projectId).getResultList();
		session.close();
		return issueCategoryList;
	}

	@Override
	public void addCategory(int projectId, IssueCategory issueCategory) {
		Session session = this.sessionFactory.openSession();
		issueCategory.setProjectId(projectId);
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(issueCategory);
		tx.commit();
		session.close();
		
	}

	@Override
	public IssueCategory getIssueCategory(int categoryId) {
		Session session = this.sessionFactory.openSession();
		IssueCategory issueCategory = session.get(IssueCategory.class, categoryId);
		session.close();
		return issueCategory;
	}



}
