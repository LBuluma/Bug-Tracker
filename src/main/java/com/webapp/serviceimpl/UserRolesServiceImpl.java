package com.webapp.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webapp.constants.CommonConstants;
import com.webapp.dao.UserRolesDao;
import com.webapp.facade.AuthenticationFacade;
import com.webapp.model.UserRoles;
import com.webapp.service.UserRolesService;

@Service
public class UserRolesServiceImpl implements UserRolesService{

	@Autowired
	private UserRolesDao userRolesDao;
	
	//Authentication object 
	   @Autowired
	    private AuthenticationFacade authenticationFacade;
	
	@Override
	public List<UserRoles> getUserRoles() {
		return userRolesDao.getUserRoles();
	}

	@Override
	@Transactional
	public void addNewUserRole(UserRoles userRoles) {
		userRoles.setCreatedDate(CommonConstants.CURRENT_STR_DATE);
		userRolesDao.addNewUserRole(userRoles);		
	}

	@Override
	public UserRoles getUserRole(int roleId) {
		return userRolesDao.getUserRole(roleId);
	}

	

}
