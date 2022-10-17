package com.webapp.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.webapp.dao.ApplicationUserDao;
import com.webapp.model.ApplicationUser;



@Repository
public class ApplicationUserDaoImpl implements  ApplicationUserDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	@Override
	public void saveAppUsr(ApplicationUser appUsr) {
		//Get the current session 
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(appUsr);
		tx.commit();
		session.close();
		
	}

	@Override
	public String getUserIdByName(String email) {
		//Get the current session 
				Session session = this.sessionFactory.openSession();
				String userId = session.createQuery("select userId from "
						+ "ApplicationUser where email = :nEmail").
						setParameter("nEmail", email).getSingleResult().toString();
				session.close();
				return userId;
				
		
	}

}
