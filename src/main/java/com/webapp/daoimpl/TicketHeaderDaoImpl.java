package com.webapp.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.webapp.dao.TicketHeaderDao;
import com.webapp.model.TicketHeader;

@Repository
public class TicketHeaderDaoImpl implements TicketHeaderDao{
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<TicketHeader> getTickets(int projectId) {
		Session session = this.sessionFactory.openSession();
		List<TicketHeader> ticketHeaderList = session.createQuery("from TicketHeader where projectId := projectId").
				setParameter("projectId", projectId).getResultList();
		session.close();
		return ticketHeaderList;
	}

	@Override
	public void addNewTicket(int projectId, TicketHeader ticketHeader) {
		Session session = this.sessionFactory.openSession();
		ticketHeader.setProject_id(projectId);
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(ticketHeader);
		tx.commit();
		session.close();
		
	}

	@Override
	public TicketHeader getTicket(int ticketHeaderId) {
		Session session = this.sessionFactory.openSession();
		TicketHeader ticketHeader = session.get(TicketHeader.class, ticketHeaderId);
		session.close();
		return ticketHeader;
	}

	

}
