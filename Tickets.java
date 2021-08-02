package com.voizfonica.project;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tickets {
	private int ticketid;
	private int customerid;
	@Column(name = "ticketdiscription")
	private String ticketdiscription;
	@Column(name = "ticketstatus")
	private String ticketstatus;

	public Tickets() {
		super();
	}

	public Tickets(int ticketid, int customerid, String ticketdescription, String ticketstatus) {
		super();
		this.ticketid = ticketid;
		this.customerid = customerid;
		this.ticketdiscription = ticketdescription;
		this.ticketstatus = ticketstatus;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getTicketid() {
		return ticketid;
	}

	public int getCustomerid() {
		return customerid;
	}

	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}

	public String getTicketdiscription() {
		return ticketdiscription;
	}

	public void setTicketdiscription(String ticketdiscription) {
		this.ticketdiscription = ticketdiscription;
	}

	public String getTicketstatus() {
		return ticketstatus;
	}

	public void setTicketstatus(String ticketstatus) {
		this.ticketstatus = ticketstatus;
	}

	public void setTicketid(int ticketid) {
		this.ticketid = ticketid;
	}

}
