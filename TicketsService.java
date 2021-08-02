package com.voizfonica.project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketsService {
	@Autowired
	private TicketsRepository ticketsRepository;
	
	public Tickets saveTicket(Tickets ticket) {
		return ticketsRepository.save(ticket);
	}
	public List<Tickets> getTicket(int customerId) {
		return ticketsRepository.findBycustomerid(customerId);
	}
	public List<Tickets> getAllTickets(){
		return ticketsRepository.findAll();
}
	public void deleteTicket(int ticketid) {
		 ticketsRepository.deleteById(ticketid);
	}

}
