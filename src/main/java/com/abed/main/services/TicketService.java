package com.abed.main.services;

import java.util.ArrayList;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abed.main.daos.TicketDao;
import com.abed.main.models.Ticket;

@Service
public class TicketService {
	
	@Autowired
	TicketDao tDao ; 
	
	public void createTicket(Ticket ticket)
	{
		tDao.save(ticket); 
		
	}
	
	public Ticket getTicketById(int id)
	{
		return tDao.findById(id).get(); 
		
	}
	
	public List<Ticket> getAllTickets()
	{
		List<Ticket> allTickets = new ArrayList<Ticket>();
		tDao.findAll().forEach(s->allTickets.add(s));
		return allTickets; 
	}
	
	public void deleteTicket(Ticket ticket)
	{
		tDao.delete(ticket);
		
	}

	public void deleteAllTickets()
	{
		tDao.deleteAll();
	}
	
	public void updateTicket(Ticket ticket)
	{
		tDao.save(ticket); 
		
	}
}
