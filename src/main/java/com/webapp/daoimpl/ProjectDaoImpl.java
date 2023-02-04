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

	@Override
	public List<Project> getProjectWithUserId(int userId) {
//		Session session = this.sessionFactory.openSession();
//		List<Project> projectsList = session.createQuery("from Project").getResultList();
//		session.close();
		return null;
	}

	//gets all the projects created by the specific PM/Admin
	@Override
	public List<Project> getProjectWithOwnerId(int ownerId) {
		Session session = this.sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<Project> projectsList = session.createQuery("from  Project where owner =:ownrId").setParameter("ownrId", ownerId).getResultList();
		session.close();
		return projectsList;
		
	}

	
	//Implement the get project name method
	@Override
	public String getProjectNameWithId(int projectId) {		
		return (getProject(projectId).getProjectName());
	}

	


}
