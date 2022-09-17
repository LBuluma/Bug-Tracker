package com.webapp.serviceimpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webapp.dao.ProjectDao;
import com.webapp.model.Project;
import com.webapp.service.ProjectService;


@Service
public class ProjectServiceImpl implements ProjectService{
	
	@Autowired
	private ProjectDao projectDao;

	@Override
	public List<Project> getProjects() {
		
		return projectDao.getProjects();
	}

	@Override
	@Transactional
	public void saveProject(Project project) {
		if(project.getEndDate() == null) {
			project.setEndDate(null);
			System.out.println("Project ende date is empty");
		}
		System.out.println("End Date"+project.getEndDate());
		Date date = new Date();
		project.setCreatedBy(1);
		project.setCreatedDate(date);
		project.setOwner(1);
		project.setCreatedBy(1);
		
		System.out.println(date);
		projectDao.saveProject(project);
		
	}

	@Override
	public Project getProject(int projectId) {
		Project project = projectDao.getProject(projectId);
		return project;
	}

	
}
