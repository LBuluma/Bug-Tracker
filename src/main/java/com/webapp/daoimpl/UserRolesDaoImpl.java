package com.webapp.daoimpl;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.webapp.dao.UserRolesDao;
import com.webapp.model.UserRoles;

@Repository
public class UserRolesDaoImpl implements UserRolesDao
{

	@Autowired
	private SessionFactory sessionFactory;

	
	@SuppressWarnings("unchecked")

	@Override
	public List<UserRoles> getUserRoles() {
		Session session = this.sessionFactory.openSession();
		List<UserRoles> userRolesList = session.createQuery("from UserRoles").getResultList();
		session.close();
		return userRolesList;
	}

	@Override
	public void addNewUserRole(UserRoles userRoles) {
		Session session = this.sessionFactory.openSession();
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

	@Override
	public String getUserRoleNameWithId(int roleId) {
		return (getUserRole(roleId).getRoleName());
	}

	

}
