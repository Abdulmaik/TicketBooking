package com.abed.main.daos;



import org.springframework.data.repository.CrudRepository;

import com.abed.main.models.Ticket;

public interface TicketDao extends CrudRepository<Ticket, Integer>{
	
	 

}
