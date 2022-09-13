package com.webapp.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.webapp.dao.PriorityLevelDao;
import com.webapp.model.PriorityLevel;

@Repository
public class PriorityLevelDaoImpl implements  PriorityLevelDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	
	@SuppressWarnings("unchecked")

	@Override
	public List<PriorityLevel> getPriorityLevels() {
		Session session = this.sessionFactory.openSession();
		List<PriorityLevel> priorityLevelList = session.createQuery("from PriorityLevel").getResultList();
		session.close();
		return priorityLevelList;
	}

	@Override
	public void addNewPriorityLevel(PriorityLevel priorityLevel) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(priorityLevel);
		tx.commit();
		session.close();
		
	}

	@Override
	public PriorityLevel getPriorityLevel(int priorityId) {
		Session session = this.sessionFactory.openSession();
		PriorityLevel priorityLevel = session.get(PriorityLevel.class, priorityId);
		session.close();
		return priorityLevel;
	}



}
