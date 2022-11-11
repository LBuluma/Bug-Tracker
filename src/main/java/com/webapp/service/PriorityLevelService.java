package com.webapp.service;

import java.util.List;

import com.webapp.dto.PriorityLevelDTO;
import com.webapp.model.PriorityLevel;

public interface PriorityLevelService {
	
	// Get all Priority Level in the database
	 List<PriorityLevel> getPriorityLevels();

	// save a new PriorityLevel
	 void addNewPriorityLevel(PriorityLevelDTO priorityLevelDto);

	 
	// save an updated PriorityLevel
    void updatePriorityLevel(PriorityLevelDTO priorityLevelDto);

	// Get the Priority Level using id.
	 PriorityLevelDTO getPriorityLevel(int priorityId);
}
