package com.webapp.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.webapp.dao.IssueModuleDao;
import com.webapp.model.IssueModule;

@Repository
public class IssueModuleDaoImpl implements IssueModuleDao{

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<IssueModule> getIssueModules(int projectId) {
		Session session = this.sessionFactory.openSession();
		List<IssueModule> issueModuleList = session.createQuery("from IssueModule where projectId := projectId").
				setParameter("projectId", projectId).getResultList();
		session.close();
		return issueModuleList;
	}

	@Override
	public void addNewIssueModule(int projectId, IssueModule issueModule) {
		Session session = this.sessionFactory.openSession();
		issueModule.setProjectId(projectId);
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(issueModule);
		tx.commit();
		session.close();
		
	}

	@Override
	public IssueModule getIssueModule(int moduleId) {
		Session session = this.sessionFactory.openSession();
		IssueModule issueModule = session.get(IssueModule.class, moduleId);
		session.close();
		return issueModule;
	}


	

}
