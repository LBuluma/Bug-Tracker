package com.webapp.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.webapp.dao.ProjectDao;
import com.webapp.dto.ProjectDTO;
import com.webapp.model.Project;


@Repository
public class ProjectDaoImpl implements ProjectDao {
  
	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Project> getProjects() {
		Session session = this.sessionFactory.openSession();
		List<Project> projectsList = session.createQuery("from Project").getResultList();
		session.close();
		return projectsList;
	}

	@Override
	public void saveProject(Project project) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(project);
		tx.commit();
		session.close();
		
	}

	@Override
	public Project getProject(int projectId) {
		Session session = this.sessionFactory.openSession();
		Project project = session.get(Project.class, projectId);
		session.close();
		return project;
	}

	


}
