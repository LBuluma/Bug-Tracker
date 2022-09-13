package com.webapp.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webapp.dao.PriorityLevelDao;
import com.webapp.model.PriorityLevel;
import com.webapp.service.PriorityLevelService;

@Service
public class PriorityLevelServiceImpl implements PriorityLevelService {
	
	@Autowired
	private PriorityLevelDao priorityLevelDao;

	@Override
	public List<PriorityLevel> getPriorityLevels() {
		return priorityLevelDao.getPriorityLevels();
	}

	@Override
	@Transactional
	public void addNewPriorityLevel(PriorityLevel priorityLevel) {
		priorityLevelDao.addNewPriorityLevel(priorityLevel);		
	}

	@Override
	public PriorityLevel getPriorityLevel(int priorityId) {		// TODO Auto-generated method stub
		return priorityLevelDao.getPriorityLevel(priorityId);
	}



}
