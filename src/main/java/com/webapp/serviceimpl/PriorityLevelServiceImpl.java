package com.webapp.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webapp.constants.CommonConstants;
import com.webapp.dao.PriorityLevelDao;
import com.webapp.facade.AuthenticationFacade;
import com.webapp.model.PriorityLevel;
import com.webapp.service.PriorityLevelService;

@Service
public class PriorityLevelServiceImpl implements PriorityLevelService {
	
	@Autowired
	private PriorityLevelDao priorityLevelDao;
	
	//Authentication object 
		@Autowired
		private AuthenticationFacade authenticationFacade;


	@Override
	public List<PriorityLevel> getPriorityLevels() {
		return priorityLevelDao.getPriorityLevels();
	}

	
	//save the priority level added
	@Override
	@Transactional
	public void addNewPriorityLevel(PriorityLevel priorityLevel) {
    	priorityLevel.setCreatedBy(Integer.parseInt(authenticationFacade.getUserIdFromAuth()));
		priorityLevel.setCreatedDate(CommonConstants.CURRENT_STR_DATE);
		priorityLevelDao.addNewPriorityLevel(priorityLevel);		
	}

	@Override
	public PriorityLevel getPriorityLevel(int priorityId) {	
		return priorityLevelDao.getPriorityLevel(priorityId);
	}



}
