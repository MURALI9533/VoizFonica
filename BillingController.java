package com.voizfonica.project;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class BillingController {
	@Autowired
	private BillingService billingService;
	
	@GetMapping("/getbill/{customerid}")
	public List<Billing> getcustomerbills(@PathVariable int customerid){
		try {
			return billingService.getBill(customerid);
		}catch(Exception exception) {
			return new ArrayList<>();
		}
	}	
	@PostMapping("savebill")
	public ResponseEntity<?> savebill(@RequestBody Billing bill){
		try {
			long millis=System.currentTimeMillis();  
			java.sql.Date date=new java.sql.Date(millis);  
		
			
			bill.setDate(date);
			
		
			billingService.saveBill(bill);
			System.out.println(date+"3");
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch(Exception exception) {
			System.out.println(exception);
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
}
