package com.webapp.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webapp.dao.UserRolesDao;
import com.webapp.model.UserRoles;
import com.webapp.service.UserRolesService;

@Service
public class UserRolesServiceImpl implements UserRolesService{

	@Autowired
	private UserRolesDao userRolesDao;
	
	@Override
	public List<UserRoles> getUserRoles(int projectId) {
		return userRolesDao.getUserRoles(projectId);
	}

	@Override
	@Transactional
	public void addNewUserRole(int projectId, UserRoles userRoles) {
		userRolesDao.addNewUserRole(projectId, userRoles);		
	}

	@Override
	public UserRoles getUserRole(int roleId) {
		return userRolesDao.getUserRole(roleId);
	}

	

}
