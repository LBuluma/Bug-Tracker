package com.webapp.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.webapp.dao.TicketHeaderDao;
import com.webapp.model.TicketHeader;
import com.webapp.service.TicketHeaderService;

public class TicketHeaderServiceImpl implements TicketHeaderService {
	@Autowired 
	private TicketHeaderDao ticketHeaderDao;

	@Override
	public List<TicketHeader> getTickets(int projectId) {
		return ticketHeaderDao.getTickets(projectId);
	}

	@Override
	public void addNewTicket(int projectId, TicketHeader ticketHeader) {
		ticketHeaderDao.addNewTicket(projectId, ticketHeader);		
	}

	@Override
	public TicketHeader getTicket(int ticketHeaderId) {
		return ticketHeaderDao.getTicket(ticketHeaderId);
	}



}
