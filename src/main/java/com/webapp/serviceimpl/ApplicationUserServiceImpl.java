package com.webapp.serviceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.webapp.constants.CommonConstants;
import com.webapp.dao.ApplicationUserDao;
import com.webapp.dto.UserDTO;
import com.webapp.facade.AuthenticationFacade;
import com.webapp.model.ApplicationUser;
import com.webapp.service.ApplicationUserService;

@Service
public class ApplicationUserServiceImpl implements ApplicationUserService{

	@Autowired
	private ApplicationUserDao appUserDao;
	
	@Autowired
	private AuthenticationFacade authenticationFacade;
	
	
	@Override
	public void saveAppUsr(UserDTO userDto) {
		ApplicationUser appUsr = new ApplicationUser();
		appUsr.setCreatedBy(Integer.parseInt(authenticationFacade.getUserIdFromAuth() ));
		appUsr.setCreatedDate(CommonConstants.CURRENT_DATE);
		appUsr.setEmail(userDto.getEmail());
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

		// Hash and set the password for persistence
		appUsr.setPassword(encoder.encode(appUsr.getEmail()));
		appUsr.setRoleId(Integer.parseInt(userDto.getRoleId()));
		appUsr.setUsername(userDto.getEmail());
		appUsr.setUserId(userDto.getUserId());
		appUsr.setEnabled("1");
		appUsr.setLocked("Y");		
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
