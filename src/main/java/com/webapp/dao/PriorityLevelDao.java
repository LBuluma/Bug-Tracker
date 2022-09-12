package com.webapp.dao;

import java.util.List;

import com.webapp.model.PriorityLevel;

public interface PriorityLevelDao {
	// Get all Priority Level in the database
	public List<PriorityLevel> getPriorityLevels();

	// save a new or updated PriorityLevel
	public void addNewPriorityLevel(PriorityLevel priorityLevel);

	// Get the Priority Level using id.
	public PriorityLevel getPriorityLevel(int priorityId);
}
