package com.webapp.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.webapp.service.ApplicationUserService;

@Service
//Get the user name and user roles from the authentication object
public class AuthenticationFacadeImpl implements AuthenticationFacade{

	@Autowired
	private ApplicationUserService appUserService;
	
	
	String currentUserName = "";
	 String role = "";
	

	@Override
	public String getUserIdFromAuth() {		
		Authentication auth = appUserService.getUserAuthentication();
		currentUserName = auth.getName();
		return appUserService.getUserIdByName(currentUserName);
	}

	@Override
	public String getUserRoleFromAuth() {
		Authentication auth = appUserService.getUserAuthentication();
		return auth.getAuthorities().iterator().next().toString();
	}

}
