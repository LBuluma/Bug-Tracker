package com.webapp.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.webapp.commonfunctions.CommonUserFMethods;
import com.webapp.constants.CommonConstants;
import com.webapp.dao.ProjectAssignmentDao;
import com.webapp.dto.ProjectAssignmentDto;
import com.webapp.facade.AuthenticationFacade;
import com.webapp.model.ProjectAssignment;
import com.webapp.service.ProjectService;
import com.webapp.service.UserRolesService;
import com.webapp.service.UserService;

@Repository
public class ProjectAssignmentDaoImpl implements ProjectAssignmentDao {
	
	@Autowired
    SessionFactory sessionFactory;
	
	

	
	@Override
	@SuppressWarnings("unchecked")
	public List<ProjectAssignment> getProjectAssignments() {
		Session session = this.sessionFactory.openSession();
		
		List<ProjectAssignment>  projectAssignmentList = session.createQuery("from ProjectAssignment").getResultList();
		session.close();
		return projectAssignmentList;
	}

	@Override
	public void assignProject(ProjectAssignment projectAssignment) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(projectAssignment);
	    tx.commit();	
	    session.close();
	}

	@Override
	public ProjectAssignment getProjectAssignment(int assignedId) {
		Session session = this.sessionFactory.openSession();
		ProjectAssignment projectAssignment = session.get(ProjectAssignment.class, assignedId);
		session.close();
		return projectAssignment;
	}

	@Override
	public 
	List<ProjectAssignment> getProjectAssignmentWithProjectId(int projectId) {
        Session session = this.sessionFactory.openSession();
		
		@SuppressWarnings("unchecked")
		List<ProjectAssignment>  projectAssignmentList = 
				session.createQuery("from ProjectAssignment where flag ='Y' and projectId =:projectId").
				 setParameter("projectId", projectId)
				.getResultList();
		session.close();
		return projectAssignmentList;
	}




	
	
	


}
