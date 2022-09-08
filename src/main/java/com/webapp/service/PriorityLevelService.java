package com.webapp.service;

import java.util.List;

import com.webapp.model.PriorityLevel;

public interface PriorityLevelService {
	
	// Get all Priority Level in the database
	public List<PriorityLevel> getPriorityLevels();

	// save a new or updated PriorityLevel
	public void addNewPriorityLevel(PriorityLevel priorityLevel);

	// Get the Priority Level using id.
	public PriorityLevel getPriorityLevel(int priorityId);
}
