package com.webapp.dao;

import java.util.List;

import com.webapp.model.TicketComment;

public interface TicketCommentDao {
	// Get all Ticket in the database for the ticket
	public List<TicketComment> getTicketComments(String ticketHeaderId);

	// save a new or updated Ticket comment
	public void addNewTicketComment(String ticketHeaderId,TicketComment ticketComment);

	// Get the Ticket comment using id.
	public TicketComment getTicketComment(String ticketHeaderId);
}
