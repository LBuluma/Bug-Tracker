package com.webapp.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.webapp.dao.UserDao;
import com.webapp.model.User;

@Repository
public class UserDaoImpl implements UserDao {

	public UserDaoImpl() {
		// TODO Auto-generated constructor stub
	}
	@Autowired
	private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    @Override
	public void saveUser(User usr) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(usr);
		tx.commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getUsers() {
		System.out.println("getUsers:IN");
		Session session = this.sessionFactory.openSession();
		List<User> userList = session.createQuery("from User").getResultList();
		session.close();
		return userList;
	}
	
	
	public  User getUser(int usrId) {
		Session session = this.sessionFactory.openSession();
		User user = session.get(User.class, usrId);
		session.close();
		return user;
		
	}
	
//	public void deleteUser(int usrId) {
//	Session session = sessionFactory.getCurrentSession();
//	User user = session.
//       
//		
//	}
  
	




}
