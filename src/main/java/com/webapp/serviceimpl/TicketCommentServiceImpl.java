package com.webapp.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.webapp.dao.TicketCommentDao;
import com.webapp.model.TicketComment;
import com.webapp.service.TicketCommentService;

public class TicketCommentServiceImpl implements TicketCommentService{
	@Autowired
	private TicketCommentDao ticketCommentDao;

	@Override
	public List<TicketComment> getTicketComments(int ticketHeaderId) {
		return ticketCommentDao.getTicketComments(ticketHeaderId);
	}

	@Override
	public void addNewTicketComment(int ticketHeaderId, TicketComment ticketComment) {
		
		ticketCommentDao.addNewTicketComment(ticketHeaderId, ticketComment);
	}

	@Override
	public TicketComment getTicketComment(int ticketHeaderId) {
		return ticketCommentDao.getTicketComment(ticketHeaderId);
	}



}
