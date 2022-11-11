package com.webapp.dto;



public class PriorityLevelDTO {
	
     private int priorityId;
	
	
	private String priorityName;
	
	private int levelPlan;
	
	private int updatedBy;
	
	private int createdBy;
	
	private String createdDate;
	
	private String updatedDate;

	public int getPriorityId() {
		return priorityId;
	}

	public void setPriorityId(int priorityId) {
		this.priorityId = priorityId;
	}

	public String getPriorityName() {
		return priorityName;
	}

	public void setPriorityName(String priorityName) {
		this.priorityName = priorityName;
	}

	public int getLevelPlan() {
		return levelPlan;
	}

	public void setLevelPlan(int levelPlan) {
		this.levelPlan = levelPlan;
	}

	public int getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(int updatedBy) {
		this.updatedBy = updatedBy;
	}

	public int getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}
	
	
	

}
