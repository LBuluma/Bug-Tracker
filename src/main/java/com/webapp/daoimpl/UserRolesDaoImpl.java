package com.webapp.daoimpl;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.webapp.dao.UserRolesDao;
import com.webapp.model.TicketComment;
import com.webapp.model.UserRoles;

public class UserRolesDaoImpl implements UserRolesDao
{

	@Autowired
	private SessionFactory sessionFactory;

	
	@SuppressWarnings("unchecked")

	@Override
	public List<UserRoles> getUserRoles(int projectId) {
		Session session = this.sessionFactory.openSession();
		List<UserRoles> userRolesList = session.createQuery("from UserRoles where projectId := projectId").
				setParameter("projectId", projectId).getResultList();
		session.close();
		return userRolesList;
	}

	@Override
	public void addNewUserRole(int projectId, UserRoles userRoles) {
		Session session = this.sessionFactory.openSession();
		userRoles.setProjectId(projectId);
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(userRoles);
		tx.commit();
		session.close();
		
	}

	@Override
	public UserRoles getUserRole(int roleId) {
		Session session = this.sessionFactory.openSession();
		UserRoles userRoles = session.get(UserRoles.class, roleId);
		session.close();
		return userRoles;
	}

	

}
