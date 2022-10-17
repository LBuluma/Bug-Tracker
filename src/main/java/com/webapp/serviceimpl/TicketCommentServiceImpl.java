package com.webapp.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webapp.constants.CommonConstants;
import com.webapp.dao.TicketCommentDao;
import com.webapp.facade.AuthenticationFacade;
import com.webapp.model.TicketComment;
import com.webapp.service.TicketCommentService;

@Service
public class TicketCommentServiceImpl implements TicketCommentService{
	@Autowired
	private TicketCommentDao ticketCommentDao;
	
	//Authentication object 
	   @Autowired
	    private AuthenticationFacade authenticationFacade;

	@Override
	public List<TicketComment> getTicketComments(int ticketHeaderId) {
		return ticketCommentDao.getTicketComments(ticketHeaderId);
	}

	@Override
	@Transactional
	public void addNewTicketComment(int ticketHeaderId, TicketComment ticketComment) {
		ticketComment.setCreatedDate(CommonConstants.CURRENT_STR_DATE);
		ticketComment.setCreatedBy(Integer.parseInt(authenticationFacade.getUserIdFromAuth()));
		ticketCommentDao.addNewTicketComment(ticketHeaderId, ticketComment);
	}

	@Override
	public TicketComment getTicketComment(int ticketHeaderId) {
		return ticketCommentDao.getTicketComment(ticketHeaderId);
	}



}
