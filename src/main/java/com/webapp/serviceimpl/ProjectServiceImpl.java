package com.webapp.serviceimpl;

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
		projectDao.saveProject(project);
		
	}

	@Override
	public Project getProject(int projectId) {
		Project project = projectDao.getProject(projectId);
		return project;
	}

	
}
