package com.webapp.service;

import org.springframework.security.core.Authentication;

import com.webapp.dto.UserDTO;

public interface ApplicationUserService {
	
    void saveAppUsr(UserDTO userDto);
   
    String getUserIdByName(String email);
    
    Authentication getUserAuthentication();
   
   
   

}
