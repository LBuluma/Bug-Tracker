package com.webapp.service;

import org.springframework.security.core.Authentication;

import com.webapp.dto.UserDTO;
import com.webapp.model.ApplicationUser;

public interface ApplicationUserService {
	
    void saveAppUsr(UserDTO userDto);
   
    String getUserIdByName(String email);
    
    ApplicationUser getApplicationUserById(String userId);
    
    Authentication getUserAuthentication();
   
   
   

}
