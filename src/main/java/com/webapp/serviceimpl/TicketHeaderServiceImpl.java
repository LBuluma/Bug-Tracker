package com.webapp.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webapp.constants.CommonConstants;
import com.webapp.dao.TicketHeaderDao;
import com.webapp.facade.AuthenticationFacade;
import com.webapp.model.TicketHeader;
import com.webapp.service.TicketHeaderService;


@Service
public class TicketHeaderServiceImpl implements TicketHeaderService {
	@Autowired 
	private TicketHeaderDao ticketHeaderDao;
	
	//Authentication object 
	   @Autowired
	    private AuthenticationFacade authenticationFacade;


	@Override
	public List<TicketHeader> getTickets(int projectId) {
		return ticketHeaderDao.getTickets(projectId);
	}

	@Override
	@Transactional
	public void addNewTicket(int projectId, TicketHeader ticketHeader) {
		ticketHeader.setCreatedBy(Integer.parseInt(authenticationFacade.getUserIdFromAuth()));
		ticketHeader.setCreatedDate(CommonConstants.CURRENT_STR_DATE);
		ticketHeaderDao.addNewTicket(projectId, ticketHeader);		
	}

	@Override
	public TicketHeader getTicket(int ticketHeaderId) {
		return ticketHeaderDao.getTicket(ticketHeaderId);
	}



}
