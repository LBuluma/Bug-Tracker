package com.webapp.serviceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.webapp.dao.ApplicationUserDao;
import com.webapp.model.ApplicationUser;
import com.webapp.service.ApplicationUserService;

@Service
public class ApplicationUserServiceImpl implements ApplicationUserService{

	@Autowired
	private ApplicationUserDao appUserDao;
	
	
	@Override
	public void saveAppUsr(ApplicationUser appUsr) {
		appUserDao.saveAppUsr(appUsr);
	}


	//Get the user id from the email of the user
	@Override
	public String getUserIdByName(String email) {
		
		return appUserDao.getUserIdByName(email);
	}


	
	//Return the Authentication object from the security context holder 
	@Override
	public Authentication getUserAuthentication() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
		    return authentication;
		}
		return null;
	}
	

	
	

}
