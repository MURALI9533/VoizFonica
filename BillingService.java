package com.voizfonica.project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillingService {
	@Autowired
	private BillingRepository billingRepository;
	public List<Billing> getBill(int id) {
		return billingRepository.findBycustomerid(id);
	}
	public Billing saveBill(Billing bill) {
		System.out.println(bill);
		
		return billingRepository.save(bill);
	}

}
