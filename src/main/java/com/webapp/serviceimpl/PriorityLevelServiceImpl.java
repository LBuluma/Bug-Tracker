package com.webapp.serviceimpl;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webapp.commonfunctions.CommonUserFMethods;
import com.webapp.constants.CommonConstants;
import com.webapp.dao.PriorityLevelDao;
import com.webapp.dto.PriorityLevelDTO;
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
	
	
	private PriorityLevelDTO priorityLevelDTO;
	
	
	private PriorityLevel priorityLevel;


	@Override
	public List<PriorityLevel> getPriorityLevels() {
		return priorityLevelDao.getPriorityLevels();
	}

	
	//save the priority level added
	@Override
	@Transactional
	public void addNewPriorityLevel(PriorityLevelDTO priorityLevelDto) {
		priorityLevel = new PriorityLevel();
		priorityLevel.setLevelPlan(priorityLevelDto.getLevelPlan());
		priorityLevel.setPriorityName(priorityLevelDto.getPriorityName());
    	priorityLevel.setCreatedBy(Integer.parseInt(authenticationFacade.getUserIdFromAuth()));
		priorityLevel.setCreatedDate(CommonConstants.CURRENT_DATE);
		priorityLevelDao.addNewPriorityLevel(priorityLevel);		
	}
	
	//save the priority level added
	@Override
	@Transactional
	public void updatePriorityLevel(PriorityLevelDTO priorityLevelDto) {
		priorityLevel = new PriorityLevel();
		priorityLevel.setPriorityId(priorityLevelDto.getPriorityId());
		priorityLevel.setLevelPlan(priorityLevelDto.getLevelPlan());
		priorityLevel.setPriorityName(priorityLevelDto.getPriorityName());
		priorityLevel.setCreatedBy(priorityLevelDto.getCreatedBy());
		try {
			priorityLevel.setCreatedDate(CommonUserFMethods.convertToDate(priorityLevelDto.getCreatedDate()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
    	priorityLevel.setUpdatedBy(Integer.parseInt(authenticationFacade.getUserIdFromAuth()));
		priorityLevel.setUpdatedDate(CommonConstants.CURRENT_DATE);
		priorityLevelDao.addNewPriorityLevel(priorityLevel);		
	}


	@Override
	public PriorityLevelDTO getPriorityLevel(int priorityId) {	
		priorityLevel = priorityLevelDao.getPriorityLevel(priorityId);
		priorityLevelDTO = new PriorityLevelDTO();
		priorityLevelDTO.setCreatedBy(priorityLevel.getCreatedBy());
		priorityLevelDTO.setCreatedDate(CommonUserFMethods.convertDateToString(priorityLevel.getCreatedDate()));
		priorityLevelDTO.setLevelPlan(priorityLevel.getLevelPlan());
		priorityLevelDTO.setPriorityId(priorityLevel.getPriorityId());
		priorityLevelDTO.setPriorityName(priorityLevel.getPriorityName());
		
		if(priorityLevel.getUpdatedDate()!=null ) {
		priorityLevelDTO.setUpdatedBy(priorityLevel.getUpdatedBy());
		priorityLevelDTO.setUpdatedDate(CommonUserFMethods.convertDateToString(priorityLevel.getUpdatedDate()));
		}
		return priorityLevelDTO;
	}



}
