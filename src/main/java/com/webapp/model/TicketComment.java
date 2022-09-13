package com.webapp.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class TicketComment {

	@Id
	@Column(name = "comment_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int commentId;

	@Column(name = "ticket_hdr_id ")
	private int ticketHeaderId;

	@Column(name = "ticket_assign_id")
	private int ticketAssignId;

	@Column(name = "comment_details")
	private String commentDetails;

	@Column(name = "status")
	private int status;

	@Column(name = "updated_by")
	private int updatedBy;

	@Column(name = "created_by")
	private int createdBy;

	@Column(name = "created_date")
	private Date createdDate;

	@Column(name = "updated_date")
	private Date updatedDate;
	
	public TicketComment() {
		super();
	}

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public int getTicketHeaderId() {
		return ticketHeaderId;
	}

	public void setTicketHeaderId(int ticketHeaderId) {
		this.ticketHeaderId = ticketHeaderId;
	}

	public int getTicketAssignId() {
		return ticketAssignId;
	}

	public void setTicketAssignId(int ticketAssignId) {
		this.ticketAssignId = ticketAssignId;
	}

	public String getCommentDetails() {
		return commentDetails;
	}

	public void setCommentDetails(String commentDetails) {
		this.commentDetails = commentDetails;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
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

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	

	

}
