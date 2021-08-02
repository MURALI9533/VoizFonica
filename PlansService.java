package com.voizfonica.project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlansService {
	@Autowired
	private PlansRepository plansRepository;
	public List<Plans> fetchPlansByPlanType(String planType) {
		return plansRepository.findByplantype(planType);
		
	}
	public Plans save(Plans plans) {
		
		return plansRepository.save(plans);
	}
	public List<Plans> getAllPlans(){
		return plansRepository.findAll();
	}
	public void deletePlan(int id) {
		plansRepository.deleteById(id);
	}
	public Plans getPlanById(int id) {
		return plansRepository.findByplanid(id);
	}

}