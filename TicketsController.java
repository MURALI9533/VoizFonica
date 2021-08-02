package com.voizfonica.project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class TicketsController {
	@Autowired
	private TicketsService ticketsService;
	
	@GetMapping("/getalltickets")
	public ResponseEntity<List<?>> getAllTickets(){
		try {
			return new ResponseEntity<List<?>>(ticketsService.getAllTickets(),HttpStatus.OK);
		}
		catch(Exception exception) {
			return new ResponseEntity<List<?>>(HttpStatus.BAD_REQUEST);
		}
	}
	@PostMapping("/saveticket")
	public ResponseEntity<?> saveTicket(@RequestBody Tickets ticket){
		try {
			return new ResponseEntity<Tickets>(ticketsService.saveTicket(ticket),HttpStatus.OK);
		}
		catch(Exception exception) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	@GetMapping("/getcustomertickets/{customerid}")
	public ResponseEntity<List<?>> getTicket(@PathVariable int customerid){
		try {
			return new ResponseEntity<List<?>>(ticketsService.getTicket(customerid),HttpStatus.OK);
		}
		catch(Exception exception) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	@DeleteMapping("/deleteticket/{ticketid}")
	public ResponseEntity deleteTicket(@PathVariable int ticketid){
		try {
			ticketsService.deleteTicket(ticketid);
			return new ResponseEntity (HttpStatus.OK);
		}
		catch(Exception exception) {
			exception.printStackTrace();
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
	}

}
