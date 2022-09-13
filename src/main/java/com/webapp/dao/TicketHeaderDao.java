package com.webapp.dao;

import java.util.List;

import com.webapp.model.TicketHeader;

public interface TicketHeaderDao {
	// Get all Ticket in the database for a specific project
			public List<TicketHeader> getTickets(int projectId);

			// save a new or updated Ticket
			public void addNewTicket(int projectId, TicketHeader ticketHeader);

			// Get the Ticket  using id.
			public TicketHeader getTicket(int ticketHeaderId);

}
