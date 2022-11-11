package com.webapp.serviceimpl;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webapp.commonfunctions.CommonUserFMethods;
import com.webapp.constants.CommonConstants;
import com.webapp.dao.UserDao;
import com.webapp.dto.UserDTO;
import com.webapp.facade.AuthenticationFacade;
import com.webapp.model.User;
import com.webapp.model.UserRoles;
import com.webapp.service.ApplicationUserService;
import com.webapp.service.UserRolesService;
import com.webapp.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	
	@Autowired
	private UserDao usrDao;
	
	@Autowired
	private UserRolesService userRolesService;
	
	@Autowired
	private AuthenticationFacade authenticationFacade;
	
    
    @Autowired
    private ApplicationUserService applicationUserService;




	
	//Get all the users in the application
	@Override
    public List < User > getUsers() {
        return usrDao.getUsers();
    }

	//save the user
    @Override
    @Transactional
    public void saveUser(UserDTO userdto) {
    	User usr = new User();
//    	usr.setActiveFlag(userdto.getActiveFlag());
    	usr.setCreatedBy(userdto.getCreatedBy());
    	usr.setEmail(userdto.getEmail());
    	usr.setFirstName(userdto.getFirstName());
    	usr.setSecondName(userdto.getSecondName());
    	usr.setRoleId(Integer.parseInt(userdto.getRoleId()));
    	usr.setCreatedBy(Integer.parseInt(authenticationFacade.getUserIdFromAuth()));
    	usr.setActiveFlag("Y");
    	usr.setCreatedDate(CommonConstants.CURRENT_DATE);
        usrDao.saveUser(usr);
        userdto.setUserId(usr.getUserId());
        applicationUserService.saveAppUsr(userdto);
    }
    
  //save the user
    @Override
    @Transactional
    public void updateUser(UserDTO userdto) {
    	User usr = new User();
    	usr.setCreatedBy(userdto.getCreatedBy());
    	try {
			usr.setCreatedDate(CommonUserFMethods.convertToDate(userdto.getCreatedDate()));
		} catch (ParseException e) {
		
			e.printStackTrace();
		}
    	usr.setEmail(userdto.getEmail());
    	usr.setFirstName(userdto.getFirstName());
    	usr.setSecondName(userdto.getSecondName());
    	usr.setRoleId(Integer.parseInt(userdto.getRoleId()));
    	usr.setCreatedBy(Integer.parseInt(authenticationFacade.getUserIdFromAuth()));
    	usr.setActiveFlag(userdto.getActiveFlag());
    	usr.setUpdatedBy(Integer.parseInt(authenticationFacade.getUserIdFromAuth()));
    	usr.setUpdatedDate(CommonConstants.CURRENT_DATE);
    	usr.setUserId(userdto.getUserId());
        usrDao.saveUser(usr);
    }

    @Override
  
    public UserDTO getUser(int theId) {
        User usr = usrDao.getUser(theId);
        UserDTO usrDto = new UserDTO();
        usrDto.setActiveFlag(usr.getActiveFlag());
        usrDto.setCreatedBy(usr.getCreatedBy());
        usrDto.setCreatedDate( CommonUserFMethods.convertDateToString(usr.getCreatedDate()) );
        usrDto.setEmail(usr.getEmail());
        usrDto.setFirstName(usr.getFirstName());
        usrDto.setRole(userRolesService.getUserRole(usr.getRoleId()));
        usrDto.setSecondName(usr.getSecondName());
        usrDto.setUpdatedBy(CommonUserFMethods.convertIntToString(usr.getUpdatedBy()));
        usrDto.setUpdatedDate(usr.getUpdatedDate());
        usrDto.setUserId(usr.getUserId());
        return usrDto;
    }

    @Override
  
    public List<Object> getUserDetails(int theId) {
           UserDTO usrDto = getUser(theId);
           UserRoles usrRoles = userRolesService.getUserRole(usrDto.getRole().getRoleId());
           List<Object> userDetailList = new ArrayList<Object>();
           userDetailList.add(usrDto);
           userDetailList.add(usrRoles);
           return userDetailList;
           
    }

	@Override
	public String getUserFullName(int userId) {
		
		UserDTO usr = getUser(userId);
		return usr.getFirstName().concat("  ").
				concat(usr.getSecondName());
	}

	

}
