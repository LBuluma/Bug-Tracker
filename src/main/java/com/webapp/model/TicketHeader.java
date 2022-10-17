package com.webapp.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class TicketHeader {
	
	@Id
	@Column(name = "ticket_hdr_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ticketHeaderId;
	
	@Column(name = "ticket_id")
	private String ticketId;
	
	@Column(name = "status")
	private int status;
	
	@Column(name = "help_issue_id")
	private String helpIssueId;
	
	@Column(name = "project_id")
	private int project_id;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "category_id")
	private int category_id;
	
	@Column(name = "updated_by")
	private int updatedBy;
	
	@Column(name = "created_by")
	private int createdBy;
	
	@Column(name = "created_date")
	private String createdDate;
	
	@Column(name = "updated_date")
	private String updatedDate;

	public TicketHeader() {
		super();
	}

	public int getTicketHeaderId() {
		return ticketHeaderId;
	}

	public void setTicketHeaderId(int ticketHeaderId) {
		this.ticketHeaderId = ticketHeaderId;
	}

	public String getTicketId() {
		return ticketId;
	}

	public void setTicketId(String ticket_id) {
		this.ticketId = ticket_id;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getHelpIssueId() {
		return helpIssueId;
	}

	public void setHelpIssueId(String helpIssueId) {
		this.helpIssueId = helpIssueId;
	}

	public int getProject_id() {
		return project_id;
	}

	public void setProject_id(int project_id) {
		this.project_id = project_id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
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
