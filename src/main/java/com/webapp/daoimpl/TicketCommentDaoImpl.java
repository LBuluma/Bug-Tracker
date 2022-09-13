package com.webapp.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.webapp.dao.TicketCommentDao;
import com.webapp.model.TicketComment;

@Repository
public class TicketCommentDaoImpl implements TicketCommentDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")

	@Override
	public List<TicketComment> getTicketComments(int ticketHeaderId) {
		Session session = this.sessionFactory.openSession();
		List<TicketComment> ticketCommentList = session.createQuery("from TicketComment where ticketHeaderId := ticketHeaderId").
				setParameter("ticketHeaderId", ticketHeaderId).getResultList();
		session.close();
		return ticketCommentList;
	}

	@Override
	public void addNewTicketComment(int ticketHeaderId, TicketComment ticketComment) {
		Session session = this.sessionFactory.openSession();
		ticketComment.setTicketHeaderId(ticketHeaderId);
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(ticketComment);
		tx.commit();
		session.close();
		
	}

	@Override
	public TicketComment getTicketComment(int ticketHeaderId) {
		Session session = this.sessionFactory.openSession();
		TicketComment ticketComment = session.get(TicketComment.class, ticketHeaderId);
		session.close();
		return ticketComment;
	}


}
