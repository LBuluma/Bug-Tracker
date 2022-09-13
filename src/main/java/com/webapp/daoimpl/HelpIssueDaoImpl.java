package com.webapp.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.webapp.dao.HelpIssueDao;
import com.webapp.model.HelpIssue;
import com.webapp.model.Project;

public class HelpIssueDaoImpl implements HelpIssueDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	
	@SuppressWarnings("unchecked")
	
	@Override
	public List<HelpIssue> getHelpIssues(int newModuleId) {
		Session session = this.sessionFactory.openSession();
		List<HelpIssue> helpIssueList = session.createQuery("from HelpIssue where moduleId := moduleId").
				setParameter("moduleId", newModuleId).getResultList();
		session.close();
		return helpIssueList;
	}

	@Override
	public void addNewHelpIssue(int moduleId, HelpIssue helpIssue) {
		Session session = this.sessionFactory.openSession();
		helpIssue.setModuleId(moduleId);
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(helpIssue);
		tx.commit();
		session.close();
		
	}

	@Override
	public HelpIssue getHelpIssue(int helpIssueId) {
		Session session = this.sessionFactory.openSession();
		HelpIssue helpIssue = session.get(HelpIssue.class, helpIssueId);
		session.close();
		return helpIssue;
	}

	

}
