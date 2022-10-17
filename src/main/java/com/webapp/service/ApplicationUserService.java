package com.webapp.service;

import org.springframework.security.core.Authentication;

import com.webapp.model.ApplicationUser;

public interface ApplicationUserService {
	
    void saveAppUsr(ApplicationUser appUsr);
   
    String getUserIdByName(String email);
    
    Authentication getUserAuthentication();
   
   
   

}
