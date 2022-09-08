package com.webapp.service;

import java.util.List;

import com.webapp.model.TicketComment;

public interface TicketCommentService {

	
	// Get all Ticket in the database for the ticket
		public List<TicketComment> getTicketComments(int ticketHeaderId);

		// save a new or updated Ticket comment
		public void addNewTicketComment(int ticketHeaderId,TicketComment ticketComment);

		// Get the Ticket comment using id.
		public TicketComment getTicketComment(int ticketHeaderId);

}
