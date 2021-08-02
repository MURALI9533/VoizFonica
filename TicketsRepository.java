package com.voizfonica.project;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketsRepository extends JpaRepository<Tickets,Integer> {
	public List<Tickets> findBycustomerid(int customerid);
	
	
}
