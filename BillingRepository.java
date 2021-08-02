package com.voizfonica.project;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BillingRepository extends JpaRepository<Billing, Integer> {
	public List<Billing> findBycustomerid(int id);
	

}
