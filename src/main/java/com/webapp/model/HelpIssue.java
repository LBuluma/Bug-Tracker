package com.webapp.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "tracker.help_issue_hdr")
public class HelpIssue {
	
	@Id
	@Column(name = "help_issue_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int helpIssueId;

	@Column(name = "created_date")
	private String createdDate;
	
	@Column(name = "help_issue_name")
	private String helpIssueName;
	

	@Column(name = "module_id")
	private int moduleId;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "updated_date")
	private Date updatedDate;
	
	@Column(name = "updated_by")
	private Date updatedBy;
	
	@Column(name = "created_by")
	private String createdBy;
	
	

	public HelpIssue() {
		super();
	}



	public int getHelpIssueId() {
		return helpIssueId;
	}



	public void setHelpIssueId(int helpIssueId) {
		this.helpIssueId = helpIssueId;
	}



	public String getCreatedDate() {
		return createdDate;
	}



	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}



	public String getHelpIssueName() {
		return helpIssueName;
	}



	public void setHelpIssueName(String helpIssueName) {
		this.helpIssueName = helpIssueName;
	}



	public int getModuleId() {
		return moduleId;
	}



	public void setModuleId(int moduleId) {
		this.moduleId = moduleId;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public Date getUpdatedDate() {
		return updatedDate;
	}



	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}



	public Date getUpdatedBy() {
		return updatedBy;
	}



	public void setUpdatedBy(Date updatedBy) {
		this.updatedBy = updatedBy;
	}



	public String getCreatedBy() {
		return createdBy;
	}



	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
	
	
	

}
